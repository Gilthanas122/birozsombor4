package com.greenfoxacademy.jwtretrofittesenvmocking.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.PopularMovie;
import java.util.List;

public class PopularMoviesResponseDTO {
  @JsonProperty("popular_movies")
  private List<PopularMovie> popularMovies;

  public PopularMoviesResponseDTO(List<PopularMovie> popularMovies) {
    this.popularMovies = popularMovies;
  }
}
