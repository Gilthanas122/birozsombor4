package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.PopularMovieDAO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.PopularMovieDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.PopularMoviesResponseDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.retro.PopularMoviesQuery;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.retro.PopularMovie;
import com.greenfoxacademy.jwtretrofittesenvmocking.repository.MovieRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class MovieServiceImpl implements MovieService {


  private String BASE_URL = "https://api.themoviedb.org";
  private String API_KEY = System.getenv("API_KEY");

  private MovieRepository movieRepository;
  private ApiInterface apiInterface;
  private Retrofit retrofit;

  @Autowired
  public MovieServiceImpl(MovieRepository movieRepository) {
    this.retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    this.apiInterface = this.retrofit.create(ApiInterface.class);
    this.movieRepository = movieRepository;
  }

  @Override
  public void fetchPopularMovies() {
    Call<PopularMoviesQuery> call = apiInterface.getPopularMovies(API_KEY, "en-US", 1);
    call.enqueue(new Callback<PopularMoviesQuery>() {
      @Override
      public void onResponse(Call<PopularMoviesQuery> call, Response<PopularMoviesQuery> response) {
        List<PopularMovieDAO> movies = convertPopularMoviesQueryToListOfPopularMovieDAO(response.body());
        saveAllMovie(movies);
      }

      @Override
      public void onFailure(Call<PopularMoviesQuery> call, Throwable t) {

      }
    });
  }

  @Override
  public void saveAllMovie(List<PopularMovieDAO> movies) {
    for (PopularMovieDAO movie : movies) {
      movieRepository.save(movie);
    }
  }

  @Override
  public List<PopularMovieDAO> getAllPopularMovie() {
    return movieRepository.findAll();
  }

  @Override
  public PopularMovieDTO convertPopularMovieDAOToDTO(PopularMovieDAO popularMovieDAO) {
    PopularMovieDTO popularMovieDTO = new PopularMovieDTO();
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.map(popularMovieDAO, popularMovieDTO);
    return popularMovieDTO;
  }

  @Override
  public PopularMovieDAO convertPopularMovieDTOToDAO(PopularMovieDTO popularMovieDTO) {
    PopularMovieDAO popularMovieDAO = new PopularMovieDAO();
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.map(popularMovieDTO, popularMovieDAO);
    return popularMovieDAO;
  }

  @Override
  public PopularMoviesResponseDTO createPopularMoviesResponseDTO(List<PopularMovieDAO> popularMovieDAOs) {
    List<PopularMovieDTO> popularMovieDTOs = new ArrayList<>();
    for (PopularMovieDAO popularMovieDAO : popularMovieDAOs) {
      popularMovieDTOs.add(convertPopularMovieDAOToDTO(popularMovieDAO));
    }
    return new PopularMoviesResponseDTO(popularMovieDTOs);
  }

  private List<PopularMovieDAO> convertPopularMoviesQueryToListOfPopularMovieDAO(PopularMoviesQuery responseDTO) {
    return responseDTO.getResults().stream()
        .map(popularMovie -> convertPopularMovieToPopularMovieDAO(popularMovie))
        .collect(Collectors.toList());
  }

  private PopularMovieDAO convertPopularMovieToPopularMovieDAO(PopularMovie popularMovie) {
    PopularMovieDAO popularMovieDAO = new PopularMovieDAO();
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.createTypeMap(PopularMovie.class, PopularMovieDAO.class)
        .setPostConverter(new Converter<PopularMovie, PopularMovieDAO>() {
          @Override
          public PopularMovieDAO convert(MappingContext<PopularMovie, PopularMovieDAO> context) {
            context.getDestination().setGenreIds(
                context.getSource().getGenreIds().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            context.getDestination().setRemoteDatabaseId(
                context.getSource().getId()
            );
            return context.getDestination();
          }
        }).map(popularMovie, popularMovieDAO);
    return popularMovieDAO;
  }
}
