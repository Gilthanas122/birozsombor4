package com.greenfoxacademy.redditproject.service;

import com.greenfoxacademy.redditproject.model.Post;
import java.util.List;

public interface PostService {

  List<Post> getAllPostsFromDatabaseOrderByCounterDesc();

  void addNewPostToDatabase(Post post);

  void incrementCounterField(long id);

  void decreaseCounterField(long id);

  List<Integer> getHowManyPageDoWeNeed();

  List<Post> getPostsForHomePage();

  List<Post> getPostsForSelectedPage(Integer integer);
}
