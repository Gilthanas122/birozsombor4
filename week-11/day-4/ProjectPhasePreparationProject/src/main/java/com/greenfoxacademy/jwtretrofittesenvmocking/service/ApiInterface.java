package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.retro.Actor;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.retro.PopularMoviesQuery;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

  //https://api.themoviedb.org/3/movie/popular?api_key=9537577ff4356e2086588b16cb363876&language=en-US&page=1
  @GET("/3/movie/popular")
  Call<PopularMoviesQuery> getPopularMovies(
      @Query("api_key") String apiKey,
      @Query("language") String language,
      @Query("page") int page
  );

  //https://api.themoviedb.org/3/person/1?api_key=9537577ff4356e2086588b16cb363876&language=en-US
  @GET("/3/person/{id}")
  Call<Actor> getActorById(
      @Path("id") Long id,
      @Query("api_key") String apiKey,
      @Query("language") String language
  );
}
