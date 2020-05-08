package com.greenfoxacademy.restoptionals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AwesomeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getPlaylistReturnsValidObject() throws Exception {
    mockMvc.perform(get("/awesome"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.playlist").exists())
        .andExpect(jsonPath("$.playlist[*].id").exists())
        .andExpect(jsonPath("$.playlist[*].author").exists())
        .andExpect(jsonPath("$.playlist[*].title").exists())
        .andExpect(jsonPath("$.playlist[*].genre").exists())
        .andExpect(jsonPath("$.playlist[*].year").exists())
        .andExpect(jsonPath("$.playlist[*].rating").exists());
  }

  @Test
  public void addNewSongReturnsValidObject() throws Exception {
    mockMvc.perform(post("/awesome")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "\"author\": \"AUTHOR\",\n" +
            "\"title\": \"TITLE\",\n" +
            "\"genre\": \"GENRE\",\n" +
            "\"year\": \"9999\",\n" +
            "\"rating\": \"99\"\n" +
            "}")
    )
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.playlist[*].id").exists())
        .andExpect(jsonPath("$.author", is("AUTHOR")))
        .andExpect(jsonPath("$.title", is("TITLE")))
        .andExpect(jsonPath("$.genre", is("GENRE")))
        .andExpect(jsonPath("$.year", is(9999)))
        .andExpect(jsonPath("$.rating", is(99)));
  }

  @Test
  public void deleteSongReturnsValidStatus() throws Exception {
    mockMvc.perform(delete("/awesome/1"))
        .andExpect(status().isNoContent());
  }

  @Test
  public void changeRatingFieldReturnsValidPlaylist() throws Exception {
    mockMvc.perform(put("/awesome/1?rating=0.1"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.playlist[0].rating", is(0.1)));
  }

  @Test
  public void getFavoriteSongsWithLimit() throws Exception {
    mockMvc.perform(get("/awesome/favorite?limit=1"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.playlist", hasSize(1)));
  }


}
