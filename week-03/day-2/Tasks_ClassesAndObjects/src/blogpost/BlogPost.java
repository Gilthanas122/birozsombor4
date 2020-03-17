package blogpost;

import java.sql.Date;


public class BlogPost {
  String authorName;
  String title;
  String text;
  Date publicationDate;

  public BlogPost() {

  }

  public BlogPost(String authorName, String title, String text, Date publicationDate) {
    this.authorName = authorName;
    this.title = title;
    this.text = text;
    this.publicationDate = publicationDate;
  }

}
