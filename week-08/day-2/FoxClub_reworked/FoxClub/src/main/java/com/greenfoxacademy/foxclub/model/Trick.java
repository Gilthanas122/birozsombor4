package com.greenfoxacademy.foxclub.model;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class Trick {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String imageSrc;
  private String alt;

  @ManyToMany(mappedBy = "tricks")
  private List<Fox> foxes;

  public Trick() {
  }

  public Trick(String name, String imageSrc, String alt) {
    this.name = name;
    this.imageSrc = imageSrc;
    this.alt = alt;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setImageSrc(String imageSrc) {
    this.imageSrc = imageSrc;
  }


  public List<Fox> getFoxes() {
    return foxes;
  }

  public void setFoxes(List<Fox> foxes) {
    this.foxes = foxes;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImageSrc() {
    return imageSrc;
  }

  public void setUrl(String imageSrc) {
    this.imageSrc = imageSrc;
  }

  public String getAlt() {
    return alt;
  }

  public void setAlt(String alt) {
    this.alt = alt;
  }
}
