package com.greenfoxacademy.jwtretrofittesenvmocking.model.dao;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.call.PopularMovieDTO;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class PopularMovie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  public Double popularity;
  public Integer voteCount;
  public Boolean video;
  public String posterPath;
  //id
  public Integer remoteDatabaseId;
  public Boolean adult;
  public String backdropPath;
  public String originalLanguage;
  public String originalTitle;
  public String genreIds;
  public String title;
  public Double voteAverage;
  @Lob
  public String overview;
  public String releaseDate;

  public PopularMovie() {
  }

  public PopularMovie(PopularMovieDTO resultDTO) {
    this.adult = resultDTO.getAdult();
    this.popularity = resultDTO.getPopularity();
    this.voteCount = resultDTO.getVoteCount();
    this.video = resultDTO.getVideo();
    this.posterPath = resultDTO.getPosterPath();
    this.remoteDatabaseId = resultDTO.getId();
    this.backdropPath = resultDTO.getBackdropPath();
    this.genreIds = resultDTO.getGenreIds().stream()
        .map(id -> String.valueOf(id))
        .collect(Collectors.joining(", "));
    this.originalLanguage = resultDTO.getOriginalLanguage();
    this.originalTitle = resultDTO.getOriginalTitle();
    this.overview = resultDTO.getOverview();
    this.title = resultDTO.getTitle();
    this.voteAverage = resultDTO.voteAverage;
    this.releaseDate = resultDTO.getReleaseDate();
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
