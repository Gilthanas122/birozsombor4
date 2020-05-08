package com.greenfoxacademy.restoptionals.service;

import com.greenfoxacademy.restoptionals.model.Playlist;
import com.greenfoxacademy.restoptionals.model.Song;
import com.greenfoxacademy.restoptionals.repository.SongRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {
  private SongRepository songRepository;

  @Autowired
  public SongServiceImpl(SongRepository songRepository) {
    this.songRepository = songRepository;
  }

  @Override
  public Playlist getPlaylist() {
    List<Song> songList = new ArrayList<>();
    songRepository.findAll().forEach(songList::add);
    Playlist playlist = new Playlist(songList);
    return playlist;
  }

  @Override
  public void addNewSong(Song song) {
    songRepository.save(song);
  }

  @Override
  public void deleteSong(Long id) {
    songRepository.deleteById(id);
  }

  @Override
  public void changeRatingField(Long id, Float rating) {
    Optional<Song> optionalSong = songRepository.findById(id);
    if (optionalSong.isPresent()) {
      Song foundSong = optionalSong.get();
      foundSong.setRating(rating);
      songRepository.save(foundSong);
    }
  }

  @Override
  public Playlist getPlaylistWithLimitedFavoriteSongs(Long limit) {
    List<Song> limitedFavoriteSongs = songRepository.findByOrderByRatingDesc(limit);
    return new Playlist(limitedFavoriteSongs);
  }

  @Override
  public Playlist getPlaylistBySearch(String by, String search) {
    List<Song> searchedSongs = null;
    switch (by) {
      case "author":
        searchedSongs = songRepository.getSongsBySearchedAuthor(search);
        break;
      case "genre":
        searchedSongs = songRepository.getSongsBySearchedGenre(search);
        break;
      case "year":
        searchedSongs = songRepository.getSongsBySearchedYear(Integer.valueOf(search));
        break;
    }
    Playlist searchPlaylist = new Playlist(searchedSongs);
    return searchPlaylist;
  }
}
