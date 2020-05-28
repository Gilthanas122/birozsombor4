package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.PopularMovie;
import java.util.List;

public interface MovieService {

  void updatePopularMovies();

  List<PopularMovie> getPopularMovies();
}
