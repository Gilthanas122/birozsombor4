package com.greenfoxacademy.jwtretrofittesenvmocking.model.dao;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.call.ActorDTO;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Actor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String birthday;
  private String knownForDepartment;
  private String deathday;
  private Integer remoteDatabaseId;
  private String name;
  private String alsoKnownAs;
  private Integer gender;
  @Lob
  private String biography;
  private Double popularity;
  private String placeOfBirth;
  private String profilePath;
  private Boolean adult;
  private String imdbId;
  private String homepage;

  public Actor() {
  }

  public Actor(ActorDTO actorDTO) {
    this.birthday = actorDTO.getBirthday();
    this.knownForDepartment = actorDTO.getKnownForDepartment();
    this.deathday = String.valueOf(actorDTO.getDeathday());
    this.remoteDatabaseId = actorDTO.getId();
    this.name = actorDTO.getName();
    this.alsoKnownAs = actorDTO.getAlsoKnownAs().stream().collect(Collectors.joining(", "));
    this.gender = actorDTO.getGender();
    this.biography = actorDTO.getBiography();
    this.popularity = actorDTO.getPopularity();
    this.placeOfBirth = actorDTO.getPlaceOfBirth();
    this.profilePath = actorDTO.getProfilePath();
    this.adult = actorDTO.getAdult();
    this.imdbId = actorDTO.getImdbId();
    this.homepage = actorDTO.getHomepage();
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
