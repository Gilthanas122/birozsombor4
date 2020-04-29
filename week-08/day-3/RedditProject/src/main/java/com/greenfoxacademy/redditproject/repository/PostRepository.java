package com.greenfoxacademy.redditproject.repository;

import com.greenfoxacademy.redditproject.model.Post;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

  @Query(value = "SELECT * FROM post ORDER BY counter DESC", nativeQuery = true)
  List<Post> getAllPostsWithDescendingOrder();

  @Query(value = "SELECT * FROM post ORDER BY counter DESC LIMIT 10", nativeQuery =
      true)
  List<Post> getAllPostsWithDescendingOrderWithLimitTen();

  @Query(value = "SELECT * FROM post ORDER BY counter DESC LIMIT 10 OFFSET ?1",
      nativeQuery = true)
  List<Post> getAllPostsWithDescendingOrderWithLimitTenAndSelectedOffset(Integer offset);
}
