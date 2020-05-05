package com.greenfoxacademy.redditproject.service;

import com.greenfoxacademy.redditproject.model.Post;
import com.greenfoxacademy.redditproject.model.User;
import com.greenfoxacademy.redditproject.repository.PostRepository;
import com.greenfoxacademy.redditproject.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private PostRepository postRepository;
  private UserRepository userRepository;

  @Autowired
  public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }

  @Override
  public List<Post> getAllPostsFromDatabaseOrderByCounterDesc() {
    return postRepository.getAllPostsWithDescendingOrder();
  }

  @Override
  public void addNewPostToDatabase(Post post) {
    User user = userRepository.getActiveUser();
    post.setUser(user);
    postRepository.save(post);
  }

  @Override
  public void incrementCounterField(long id) {
    Optional<Post> optionalPost = postRepository.findById(id);
    if (optionalPost.isPresent()) {
      Post post = optionalPost.get();
      post.setCounter(post.getCounter() + 1);
      postRepository.save(post);
    }
  }

  @Override
  public void decreaseCounterField(long id) {
    Optional<Post> optionalPost = postRepository.findById(id);
    if (optionalPost.isPresent()) {
      Post post = optionalPost.get();
      post.setCounter(post.getCounter() - 1);
      postRepository.save(post);
    }
  }

  @Override
  public void updatePostCounterField(String option, long id) {
    switch (option) {
      case "+":
        incrementCounterField(id);
        break;
      case "-":
        decreaseCounterField(id);
        break;
    }
  }

  @Override
  public List<Integer> getHowManyPageDoWeNeed() {
    List<Integer> pageNumbers = new ArrayList<>();
    Integer sizeOfPosts = postRepository.getAllPostsWithDescendingOrder().size();
    Integer pageNumber = 1;
    pageNumbers.add(pageNumber);
    for (int i = 1; i <= sizeOfPosts; i++) {
      if (i % 10 == 0) {
        pageNumber++;
        pageNumbers.add(pageNumber);
      }
    }
    return pageNumbers;
  }

  @Override
  public List<Post> getPostsForHomePage() {
    return postRepository.getAllPostsWithDescendingOrderWithLimitTen();
  }

  @Override
  public List<Post> getPostsWithPageNumber(Integer pageNumber) {
    if (pageNumber == 1) {
      return postRepository.getAllPostsWithDescendingOrderWithLimitTen();
    } else {
      return postRepository.getAllPostsWithDescendingOrderWithLimitTenAndSelectedOffset((pageNumber - 1) * 10);
    }
  }
}
