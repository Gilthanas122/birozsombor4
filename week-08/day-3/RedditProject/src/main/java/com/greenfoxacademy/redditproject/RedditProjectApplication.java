package com.greenfoxacademy.redditproject;

import com.greenfoxacademy.redditproject.model.Post;
import com.greenfoxacademy.redditproject.model.User;
import com.greenfoxacademy.redditproject.repository.PostRepository;
import com.greenfoxacademy.redditproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditProjectApplication implements CommandLineRunner {

  private PostRepository postRepository;
  private UserRepository userRepository;

  @Autowired
  public RedditProjectApplication(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(RedditProjectApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    postRepository.save(new Post("Facebook", "https://www.facebook.com/"));
    postRepository.save(new Post("Twitter", "https://twitter.com/explore"));
    postRepository.save(new Post("YouTube", "https://youtube.com/"));
    postRepository.save(new Post("Google", "https://google.com/"));
    postRepository.save(new Post("Instagram", "https://instagram.com/"));
  }
}
