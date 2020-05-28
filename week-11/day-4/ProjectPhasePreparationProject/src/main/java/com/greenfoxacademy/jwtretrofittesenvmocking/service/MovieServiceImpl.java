package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.PopularMovie;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.PopularMoviesResponseDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.ResultDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.repository.MovieRepository;
import java.util.List;
import java.util.stream.Collectors;
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

  public void updatePopularMovies() {
    Call<PopularMoviesResponseDTO> call = apiInterface.getPopularMovies(API_KEY, "en-US", 1);
    call.enqueue(new Callback<PopularMoviesResponseDTO>() {
      @Override
      public void onResponse(Call<PopularMoviesResponseDTO> call, Response<PopularMoviesResponseDTO> response) {
        List<PopularMovie> movies = convertResponseDTOToListOfMovies(response.body());
        for (PopularMovie movie : movies) {
          movieRepository.save(movie);
        }
      }

      @Override
      public void onFailure(Call<PopularMoviesResponseDTO> call, Throwable t) {

      }
    });
  }

  @Override
  public List<PopularMovie> getPopularMovies() {
    return movieRepository.findAll();
  }

  private List<PopularMovie> convertResponseDTOToListOfMovies(PopularMoviesResponseDTO responseDTO) {
    return responseDTO.getResults().stream()
        .map(result -> convertResultDTOToMovie(result))
        .collect(Collectors.toList());
  }

  private PopularMovie convertResultDTOToMovie(ResultDTO resultDTO) {
    PopularMovie movie = new PopularMovie();
    movie.setAdult(resultDTO.getAdult());
    movie.setPopularity(resultDTO.getPopularity());
    movie.setVoteCount(resultDTO.getVoteCount());
    movie.setVideo(resultDTO.getVideo());
    movie.setPosterPath(resultDTO.getPosterPath());
    movie.setRemoteDatabaseId(resultDTO.getId());
    movie.setBackdropPath(resultDTO.getBackdropPath());
    movie.setGenreIds(resultDTO.getGenreIds().stream()
        .map(id -> String.valueOf(id))
        .collect(Collectors.joining(", ")));
    movie.setOriginalLanguage(resultDTO.getOriginalLanguage());
    movie.setOriginalTitle(resultDTO.getOriginalTitle());
    movie.setOverview(resultDTO.getOverview());
    movie.setTitle(resultDTO.getTitle());
    movie.setVoteAverage(resultDTO.voteAverage);
    movie.setReleaseDate(resultDTO.getReleaseDate());
    return movie;
  }
}
