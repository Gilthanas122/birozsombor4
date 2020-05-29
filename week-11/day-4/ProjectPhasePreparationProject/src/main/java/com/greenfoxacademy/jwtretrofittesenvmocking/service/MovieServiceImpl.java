package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.PopularMovie;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.call.PopularMoviesDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.call.PopularMovieDTO;
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

  public void fetchPopularMovies() {
    Call<PopularMoviesDTO> call = apiInterface.getPopularMovies(API_KEY, "en-US", 1);
    call.enqueue(new Callback<PopularMoviesDTO>() {
      @Override
      public void onResponse(Call<PopularMoviesDTO> call, Response<PopularMoviesDTO> response) {
        List<PopularMovie> movies = convertResponseBodyToListOfMovies(response.body());
        saveAllMovie(movies);
      }

      @Override
      public void onFailure(Call<PopularMoviesDTO> call, Throwable t) {

      }
    });
  }

  private void saveAllMovie(List<PopularMovie> movies) {
    for (PopularMovie movie : movies) {
      movieRepository.save(movie);
    }
  }

  @Override
  public List<PopularMovie> getAllPopularMovie() {
    return movieRepository.findAll();
  }

  private List<PopularMovie> convertResponseBodyToListOfMovies(PopularMoviesDTO responseDTO) {
    return responseDTO.getResults().stream()
        .map(popularMovieDTO -> convertPopularMovieDTOToPopularMovie(popularMovieDTO))
        .collect(Collectors.toList());
  }

  private PopularMovie convertPopularMovieDTOToPopularMovie(PopularMovieDTO popularMovieDTO) {
    return new PopularMovie(popularMovieDTO);
  }
}
