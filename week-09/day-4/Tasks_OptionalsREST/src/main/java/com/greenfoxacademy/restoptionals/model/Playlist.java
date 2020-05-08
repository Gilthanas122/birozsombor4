package com.greenfoxacademy.restoptionals.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Playlist {

  @JsonProperty("playlist")
  private List<Song> songList;

  public Playlist(List<Song> songList) {
    this.songList = songList;
  }
}
