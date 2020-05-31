package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.PopularMovieDAO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.PopularMovieDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.PopularMoviesResponseDTO;
import java.util.List;

public interface MovieService {

  void fetchPopularMovies();

  List<PopularMovieDAO> getAllPopularMovie();

  void saveAllMovie(List<PopularMovieDAO> movies);

  PopularMoviesResponseDTO createPopularMoviesResponseDTO(List<PopularMovieDAO> popularMovieDAOs);

  PopularMovieDAO convertPopularMovieDTOToDAO(PopularMovieDTO popularMovieDTO);

  PopularMovieDTO convertPopularMovieDAOToDTO(PopularMovieDAO popularMovieDAO);
}
