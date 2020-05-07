package com.greenfoxacademy.rest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class GetLogEntriesEndpointTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getAllLogEntriesReturnsValidFields() throws Exception {
    mockMvc.perform(get("/log"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.entries").exists())
        .andExpect(jsonPath("$.entries[*].id").exists())
        .andExpect(jsonPath("$.entries[*].endpoint").exists())
        .andExpect(jsonPath("$.entries[*].data").exists())
        .andExpect(jsonPath("$.entry_count").exists());
  }

  @Test
  public void getAllLogEntriesWithQParamaterReturnsCorrectObjects() throws Exception {
    mockMvc.perform(get("/log?q=result"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.entries[0].data", containsString("result")));
  }


  @Test
  public void getAllLogEntriesWithQAndCountParamaterReturnsError() throws Exception {
    mockMvc.perform(get("/log?q=result&count=12"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("You cannot use q parameter with count and/or page!")));
  }

  @Test
  public void getAllLogEntriesWithQAndPageParamaterReturnsError() throws Exception {
    mockMvc.perform(get("/log?q=result&page=12"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("You cannot use q parameter with count and/or page!")));
  }

  @Test
  public void getAllLogEntriesWithQAndCountAndPageParamaterReturnsError() throws Exception {
    mockMvc.perform(get("/log?q=result&count=12"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("You cannot use q parameter with count and/or page!")));
  }

  @Test
  public void getAllLogEntriesWithCountParamaterReturnsCorrectObjects() throws Exception {
    mockMvc.perform(get("/log?count=12"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.entries", hasSize(12)));
  }

  @Test
  public void getAllLogEntriesWithPageAndWithoutCountParamaterReturnsError() throws Exception {
    mockMvc.perform(get("/log?page=2"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Please provide count as well!")));
  }

  @Test
  public void getAllLogEntriesWithPageAndCountParamaterReturnsError() throws Exception {
    mockMvc.perform(get("/log?count=5&page=2"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.entries[0].id", is(6)));
  }
}
