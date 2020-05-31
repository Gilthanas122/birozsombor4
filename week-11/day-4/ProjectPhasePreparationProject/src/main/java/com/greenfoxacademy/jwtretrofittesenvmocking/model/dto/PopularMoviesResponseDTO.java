package com.greenfoxacademy.jwtretrofittesenvmocking.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PopularMoviesResponseDTO {
  @JsonProperty("popular_movies")
  private List<PopularMovieDTO> popularMovies;

  public PopularMoviesResponseDTO(List<PopularMovieDTO> popularMovies) {
    this.popularMovies = popularMovies;
  }
}
