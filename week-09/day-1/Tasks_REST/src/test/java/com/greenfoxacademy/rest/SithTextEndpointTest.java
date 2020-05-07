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
public class SithTextEndpointTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void translateTextToSithReturnsValidAndCorrectObject() throws Exception {
    mockMvc.perform(post("/sith")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "  \"text\": \"This is my example sentence. Just for fun.\"\n" +
            "}")
    )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sith_text").exists())
        .andExpect(jsonPath("$.sith_text", containsString("Is this example my sentence.")))
        .andExpect(jsonPath("$.sith_text", containsString("For just fun.")))
        .andExpect(jsonPath("$.sith_text", anyOf(containsString("Arrgh."),
            containsString("Uhmm."), containsString("Err..err.err."))));
  }

  @Test
  public void translateTextToSithWithNullReturnsError() throws Exception {
    mockMvc.perform(post("/sith")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{}")
    )
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Feed me some text you have to, padawan " +
            "young you are. Hmmm.")));
  }
}
