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
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ArrayHandlerEndpointTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getResultOfAnArrayWithActionSumReturnsCorrectValue() throws Exception {
    mockMvc.perform(post("/arrays")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "  \"what\": \"sum\",\n" +
            "  \"numbers\": [1, 2, 5, 10]\n" +
            "}")
    )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.result", is(18)));
  }

  @Test
  public void getResultOfAnArrayWithActionMultiplyReturnsCorrectValue() throws Exception {
    mockMvc.perform(post("/arrays")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "  \"what\": \"multiply\",\n" +
            "  \"numbers\": [1, 2, 5, 10]\n" +
            "}")
    )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.result", is(100)));
  }

  @Test
  public void getResultOfAnArrayWithActionDoubleReturnsCorrectValues() throws Exception {
    mockMvc.perform(post("/arrays")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "  \"what\": \"double\",\n" +
            "  \"numbers\": [1, 2, 5, 10]\n" +
            "}")
    )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.results", hasSize(4)))
        .andExpect(jsonPath("$.results", hasItem(2)))
        .andExpect(jsonPath("$.results", hasItem(4)))
        .andExpect(jsonPath("$.results", hasItem(10)))
        .andExpect(jsonPath("$.results", hasItem(20)));
  }

  @Test
  public void getResultOfAnArrayWithMissingNumbersReturnsCorrectError() throws Exception {
    mockMvc.perform(post("/arrays")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "  \"what\": \"double\",\n" +
            "  \"numbers\": []\n" +
            "}")
    )
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error", is("Please provide numbers!")));
  }

  @Test
  public void getResultOfAnArrayWithMissingWhatReturnsCorrectError() throws Exception {
    mockMvc.perform(post("/arrays")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "  \"what\": \"\",\n" +
            "  \"numbers\": [1, 2, 5, 10]\n" +
            "}")
    )
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error", is("Please provide what to do with numbers!")));
  }


}
