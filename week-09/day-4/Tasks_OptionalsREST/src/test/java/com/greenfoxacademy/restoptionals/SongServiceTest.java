package com.greenfoxacademy.restoptionals;

import com.greenfoxacademy.restoptionals.model.Playlist;
import com.greenfoxacademy.restoptionals.model.Song;
import com.greenfoxacademy.restoptionals.repository.SongRepository;
import com.greenfoxacademy.restoptionals.service.SongService;
import com.greenfoxacademy.restoptionals.service.SongServiceImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SongServiceTest {

  private SongService songService;
  private SongRepository songRepository;

  @BeforeEach
  public void before() {
    this.songRepository = Mockito.mock(SongRepository.class);
    this.songService = new SongServiceImpl(this.songRepository);
  }

  @Test
  public void getPlayListReturnsValidPlaylist() {
    //Arrange
    List<Song> songList = Arrays.asList(
        new Song("John Lennon", "Imagine", "world-music", 1971, 8.1f),
        new Song("Metallica", "Ride the lightning", "metal", 1984, 7.5f));
    Mockito.when(songRepository.findAll()).thenReturn(songList);

    //Act
    Playlist playlist = songService.getPlaylist();

    //Assert
    Assert.assertEquals(songList, playlist.getSongList());
  }

  @Test
  public void getLimitedPlaylistWithLimitedFavoriteSongsReturnsValidPlaylistFieldSize() {
    //Arrange
    List<Song> songList = Arrays.asList(
        new Song("John Lennon", "Imagine", "world-music", 1971, 8.1f));
    Mockito.when(songRepository.findByOrderByRatingDesc(Long.valueOf(1))).thenReturn(songList);

    //Act
    Playlist playlist = songService.getPlaylistWithLimitedFavoriteSongs(Long.valueOf(1));

    //Assert
    Assert.assertEquals(1, playlist.getSongList().size());
  }

  @Test
  public void getPlaylistBySearchReturnsSongsWithSameAuthor() {
    //Arrange
    List<Song> songList = Arrays.asList(
        new Song("John Lennon", "Imagine", "world-music", 1971, 8.1f),
        new Song("John Lennon", "Imagine2", "world-music", 1971, 8.1f),
        new Song("John Lennon", "Imagine3", "world-music", 1971, 8.1f));
    Mockito.when(songRepository.getSongsBySearchedAuthor("John Lennon")).thenReturn(songList);

    //Act
    Playlist playlist = songService.getPlaylistBySearch("author", "John Lennon");

    //Assert
    for (Song song : playlist.getSongList()) {
      Assert.assertEquals("John Lennon", song.getAuthor());
    }
  }

  @Test
  public void getPlaylistBySearchReturnsSongsWithSameGenre() {
    //Arrange
    List<Song> songList = Arrays.asList(
        new Song("John Lennon", "Imagine", "world-music", 1971, 8.1f),
        new Song("John Lennon", "Imagine2", "world-music", 1971, 8.1f),
        new Song("John Lennon", "Imagine3", "world-music", 1971, 8.1f));
    Mockito.when(songRepository.getSongsBySearchedAuthor("John Lennon")).thenReturn(songList);

    //Act
    Playlist playlist = songService.getPlaylistBySearch("genre", "world-music");

    //Assert
    for (Song song : playlist.getSongList()) {
      Assert.assertEquals("world-music", song.getGenre());
    }
  }

  @Test
  public void getPlaylistBySearchReturnsSongsWithSameYear() {
    //Arrange
    List<Song> songList = Arrays.asList(
        new Song("John Lennon", "Imagine", "world-music", 1971, 8.1f),
        new Song("John Lennon", "Imagine2", "world-music", 1971, 8.1f),
        new Song("John Lennon", "Imagine3", "world-music", 1971, 8.1f));
    Mockito.when(songRepository.getSongsBySearchedAuthor("John Lennon")).thenReturn(songList);

    //Act
    Playlist playlist = songService.getPlaylistBySearch("year", "1971");

    //Assert
    for (Song song : playlist.getSongList()) {
      Assert.assertEquals(Long.valueOf(1971), song.getYear());
    }
  }
}
