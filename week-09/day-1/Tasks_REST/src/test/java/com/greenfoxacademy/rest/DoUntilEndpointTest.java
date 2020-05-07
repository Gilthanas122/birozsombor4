package com.greenfoxacademy.rest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class DoUntilEndpointTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getDoUntilWithActionSumReturnsCorrectValues() throws Exception {
    String action = "sum";
    mockMvc.perform(post("/dountil/{action}", action)
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"until\":7}")
    )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.until", is(7)))
        .andExpect(jsonPath("$.result", is(28)));
  }

  @Test
  public void getDoUntilWithActionFactorReturnsCorrectValues() throws Exception {
    String action = "factor";
    mockMvc.perform(post("/dountil/{action}", action)
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"until\":4}")
    )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.until", is(4)))
        .andExpect(jsonPath("$.result", is(24)));
  }

  @Test
  public void getDoUntilWithMissingFieldValueReturnsError() throws Exception {
    String action = "sum";
    mockMvc.perform(post("/dountil/{action}", action)
        .contentType(MediaType.APPLICATION_JSON)
        .content("{}")
    )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Please provide a number!")));
  }
}
