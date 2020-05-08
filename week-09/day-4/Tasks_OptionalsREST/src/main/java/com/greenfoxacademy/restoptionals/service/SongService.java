package com.greenfoxacademy.restoptionals.service;

import com.greenfoxacademy.restoptionals.model.Playlist;
import com.greenfoxacademy.restoptionals.model.Song;

public interface SongService {
  Playlist getPlaylist();

  void addNewSong(Song song);

  void deleteSong(Long id);

  void changeRatingField(Long id, Float rating);

  Playlist getPlaylistWithLimitedFavoriteSongs(Long limit);

  Playlist getPlaylistBySearch(String by, String search);
}
