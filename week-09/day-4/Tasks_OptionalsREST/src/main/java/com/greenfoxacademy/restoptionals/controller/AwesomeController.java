package com.greenfoxacademy.restoptionals.controller;

import com.greenfoxacademy.restoptionals.model.Playlist;
import com.greenfoxacademy.restoptionals.model.Song;
import com.greenfoxacademy.restoptionals.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwesomeController {
  private SongService songService;

  @Autowired
  public AwesomeController(SongService songService) {
    this.songService = songService;
  }

  @GetMapping("/awesome")
  public ResponseEntity getPlaylist() {
    return ResponseEntity.ok(songService.getPlaylist());
  }

  @PostMapping("/awesome")
  public ResponseEntity addNewSong(@RequestBody Song song) {
    songService.addNewSong(song);
    return ResponseEntity.status(HttpStatus.CREATED).body(song);
  }

  @DeleteMapping("/awesome/{id}")
  public ResponseEntity deleteSong(@PathVariable Long id) {
    songService.deleteSong(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/awesome/{id}")
  public ResponseEntity changeRatingFieldOfASong(@PathVariable Long id, @RequestParam Float rating) {
    songService.changeRatingField(id, rating);
    return ResponseEntity.ok(songService.getPlaylist());
  }

  @GetMapping("/awesome/favorite")
  public ResponseEntity getFavoriteSongsWithLimit(@RequestParam Long limit) {
    return ResponseEntity.ok(songService.getPlaylistWithLimitedFavoriteSongs(limit));
  }

  @GetMapping("/awesome/search/{by}")
  public ResponseEntity getSearchSongs(@PathVariable String by, @RequestParam String search) {
    return ResponseEntity.ok(songService.getPlaylistBySearch(by, search));
  }
}
