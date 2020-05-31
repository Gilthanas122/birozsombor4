package com.greenfoxacademy.jwtretrofittesenvmocking.repository;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.PopularMovieDAO;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<PopularMovieDAO, Long> {

  List<PopularMovieDAO> findAll();
}
