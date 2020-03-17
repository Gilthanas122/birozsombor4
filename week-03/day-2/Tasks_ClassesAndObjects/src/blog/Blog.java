package blog;

import blogpost.BlogPost;
import java.util.ArrayList;
import java.util.List;

public class Blog {
  List<BlogPost> listOfBlogPosts;

  public Blog() {
    listOfBlogPosts = new ArrayList<>();
  }

  public void add(BlogPost blogPost){
    this.listOfBlogPosts.add(blogPost);
  }

  public void delete(int index){
    this.listOfBlogPosts.remove(index);
  }

  public void update(int index, BlogPost blogPost){
    this.listOfBlogPosts.set(index, blogPost);
  }
}
