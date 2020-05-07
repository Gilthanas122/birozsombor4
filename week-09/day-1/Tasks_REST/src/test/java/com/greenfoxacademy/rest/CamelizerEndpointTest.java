package com.greenfoxacademy.rest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
public class CamelizerEndpointTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getCamelizedObjectWithLangHuReturnsValidObject() throws Exception {
    mockMvc.perform(post("/translate")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "  \"text\": \"Ez egy.\",\n" +
            "  \"lang\": \"hu\"\n" +
            "}")
    )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.text", is("Evez evegy.")))
        .andExpect(jsonPath("$.lang", is("teve")));
  }

  @Test
  public void getCamelizedObjectWithLangEngReturnsValidObject() throws Exception {
    mockMvc.perform(post("/translate")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "  \"text\": \"bad\",\n" +
            "  \"lang\": \"eng\"\n" +
            "}")
    )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.text", is("bidigad")))
        .andExpect(jsonPath("$.lang", is("gibberish")));
  }

  @Test
  public void getCamelizedObjectWithLangNullReturnError() throws Exception {
    mockMvc.perform(post("/translate")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "  \"text\": \"bad\"\n" +
            "}")
    )
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("I can't translate that!")));
  }

  @Test
  public void getCamelizedObjectWithTextNullReturnError() throws Exception {
    mockMvc.perform(post("/translate")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "  \"lang\": \"eng\"\n" +
            "}")
    )
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("I can't translate that!")));
  }
}
