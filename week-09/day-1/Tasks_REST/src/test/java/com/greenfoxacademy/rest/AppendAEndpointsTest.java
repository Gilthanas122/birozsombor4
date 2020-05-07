package com.greenfoxacademy.rest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class AppendAEndpointsTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getWordWithAppendAReturnsInputWithAppendedA() throws Exception {
    String appendable = "kuty";
    mockMvc.perform(get("/appenda/{appendable}", appendable))
        .andExpect(status().isOk())
        .andExpect(content().contentType(org.springframework.http.MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.appended", is("kutya")));
  }

  @Test
  public void getWordWithAppendAReturnsError() throws Exception {
    String appendable = "";
    mockMvc.perform(get("/appenda/{appendable}", appendable))
        .andExpect(status().isNotFound());

  }
}
