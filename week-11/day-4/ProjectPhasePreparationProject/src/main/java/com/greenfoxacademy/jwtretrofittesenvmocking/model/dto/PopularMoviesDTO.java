package com.greenfoxacademy.jwtretrofittesenvmocking.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.PopularMovie;
import java.util.List;

public class PopularMoviesDTO {
  @JsonProperty("popular_movies")
  private List<PopularMovie> popularMovies;

  public PopularMoviesDTO(List<PopularMovie> popularMovies) {
    this.popularMovies = popularMovies;
  }

  public List<PopularMovie> getPopularMovies() {
    return popularMovies;
  }

  public void setPopularMovies(List<PopularMovie> popularMovies) {
    this.popularMovies = popularMovies;
  }
}
