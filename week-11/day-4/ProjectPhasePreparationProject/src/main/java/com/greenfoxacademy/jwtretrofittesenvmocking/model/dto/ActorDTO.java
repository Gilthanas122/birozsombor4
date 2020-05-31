package com.greenfoxacademy.jwtretrofittesenvmocking.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActorDTO {

  private Long id;
  private String birthday;
  @JsonProperty("known_for_department")
  private String knownForDepartment;
  private String deathday;
  @JsonProperty("remote_database_id")
  private Integer remoteDatabaseId;
  private String name;
  @JsonProperty("also_known_as")
  private String alsoKnownAs;
  private Integer gender;
  private String biography;
  private Double popularity;
  @JsonProperty("place_of_birth")
  private String placeOfBirth;
  @JsonProperty("profile_path")
  private String profilePath;
  private Boolean adult;
  @JsonProperty("imdb_id")
  private String imdbId;
  private String homepage;

  public ActorDTO() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getKnownForDepartment() {
    return knownForDepartment;
  }

  public void setKnownForDepartment(String knownForDepartment) {
    this.knownForDepartment = knownForDepartment;
  }

  public String getDeathday() {
    return deathday;
  }

  public void setDeathday(String deathday) {
    this.deathday = deathday;
  }

  public Integer getRemoteDatabaseId() {
    return remoteDatabaseId;
  }

  public void setRemoteDatabaseId(Integer remoteDatabaseId) {
    this.remoteDatabaseId = remoteDatabaseId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAlsoKnownAs() {
    return alsoKnownAs;
  }

  public void setAlsoKnownAs(String alsoKnownAs) {
    this.alsoKnownAs = alsoKnownAs;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public String getBiography() {
    return biography;
  }

  public void setBiography(String biography) {
    this.biography = biography;
  }

  public Double getPopularity() {
    return popularity;
  }

  public void setPopularity(Double popularity) {
    this.popularity = popularity;
  }

  public String getPlaceOfBirth() {
    return placeOfBirth;
  }

  public void setPlaceOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }

  public String getProfilePath() {
    return profilePath;
  }

  public void setProfilePath(String profilePath) {
    this.profilePath = profilePath;
  }

  public Boolean getAdult() {
    return adult;
  }

  public void setAdult(Boolean adult) {
    this.adult = adult;
  }

  public String getImdbId() {
    return imdbId;
  }

  public void setImdbId(String imdbId) {
    this.imdbId = imdbId;
  }

  public String getHomepage() {
    return homepage;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }
}
