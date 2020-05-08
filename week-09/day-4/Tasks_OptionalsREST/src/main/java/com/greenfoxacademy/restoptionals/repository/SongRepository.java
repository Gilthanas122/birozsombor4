package com.greenfoxacademy.restoptionals.repository;

import com.greenfoxacademy.restoptionals.model.Song;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

  @Query(value = "SELECT * FROM song ORDER BY rating DESC LIMIT :limit", nativeQuery = true)
  List<Song> findByOrderByRatingDesc(Long limit);

  @Query(value = "SELECT * FROM song WHERE author LIKE :text ", nativeQuery = true)
  List<Song> getSongsBySearchedAuthor(String text);

  @Query(value = "SELECT * FROM song WHERE genre LIKE :text ", nativeQuery = true)
  List<Song> getSongsBySearchedGenre(String text);

  @Query(value = "SELECT * FROM song WHERE year = :valueOf", nativeQuery = true)
  List<Song> getSongsBySearchedYear(Integer valueOf);
}
