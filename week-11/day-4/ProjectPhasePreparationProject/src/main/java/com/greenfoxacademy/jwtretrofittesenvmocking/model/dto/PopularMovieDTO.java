package com.greenfoxacademy.jwtretrofittesenvmocking.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PopularMovieDTO {

  private Long id;
  public Double popularity;
  @JsonProperty("vote_count")
  public Integer voteCount;
  public Boolean video;
  @JsonProperty("poster_path")
  public String posterPath;
  @JsonProperty("remote_database_id")
  public Integer remoteDatabaseId;
  public Boolean adult;
  @JsonProperty("backdrop_path")
  public String backdropPath;
  @JsonProperty("original_language")
  public String originalLanguage;
  @JsonProperty("original_title")
  public String originalTitle;
  @JsonProperty("genre_ids")
  public String genreIds;
  public String title;
  @JsonProperty("vote_average")
  public Double voteAverage;
  public String overview;
  @JsonProperty("release_date")
  public String releaseDate;

  public PopularMovieDTO() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getPopularity() {
    return popularity;
  }

  public void setPopularity(Double popularity) {
    this.popularity = popularity;
  }

  public Integer getVoteCount() {
    return voteCount;
  }

  public void setVoteCount(Integer voteCount) {
    this.voteCount = voteCount;
  }

  public Boolean getVideo() {
    return video;
  }

  public void setVideo(Boolean video) {
    this.video = video;
  }

  public String getPosterPath() {
    return posterPath;
  }

  public void setPosterPath(String posterPath) {
    this.posterPath = posterPath;
  }

  public Integer getRemoteDatabaseId() {
    return remoteDatabaseId;
  }

  public void setRemoteDatabaseId(Integer remoteDatabaseId) {
    this.remoteDatabaseId = remoteDatabaseId;
  }

  public Boolean getAdult() {
    return adult;
  }

  public void setAdult(Boolean adult) {
    this.adult = adult;
  }

  public String getBackdropPath() {
    return backdropPath;
  }

  public void setBackdropPath(String backdropPath) {
    this.backdropPath = backdropPath;
  }

  public String getOriginalLanguage() {
    return originalLanguage;
  }

  public void setOriginalLanguage(String originalLanguage) {
    this.originalLanguage = originalLanguage;
  }

  public String getOriginalTitle() {
    return originalTitle;
  }

  public void setOriginalTitle(String originalTitle) {
    this.originalTitle = originalTitle;
  }

  public String getGenreIds() {
    return genreIds;
  }

  public void setGenreIds(String genreIds) {
    this.genreIds = genreIds;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Double getVoteAverage() {
    return voteAverage;
  }

  public void setVoteAverage(Double voteAverage) {
    this.voteAverage = voteAverage;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }
}
