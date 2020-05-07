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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class GreeterEndpointTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getWelcomeMessageWithValidInputParametersReturnsCorrectResponse() throws Exception {
    mockMvc.perform(get("/greeter?name=Vader&title=Sith"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.welcome_message", is("Oh, hi there Vader, my dear Sith!")));
  }

  @Test
  public void getWelcomeMessageWithMissingTitleReturnsCorrectError() throws Exception {
    mockMvc.perform(get("/greeter?name=Vader"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Please provide a title!")));
  }

  @Test
  public void getWelcomeMessageWithMissingNameReturnsCorrectError() throws Exception {
    mockMvc.perform(get("/greeter?title=Vader"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Please provide a name!")));
  }

  @Test
  public void getWelcomeMessageWithMissingParametersReturnsCorrectError() throws Exception {
    mockMvc.perform(get("/greeter"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Please provide a name and a title!")));
  }
}
