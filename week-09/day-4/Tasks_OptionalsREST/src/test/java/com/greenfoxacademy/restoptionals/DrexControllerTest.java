package com.greenfoxacademy.restoptionals;

import com.sun.org.apache.xpath.internal.operations.String;
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
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
public class DrexControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getCalorieTableReturnsValidObject() throws Exception {
    mockMvc.perform(get("/drax"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.foods[*].id").exists())
        .andExpect(jsonPath("$.foods[*].amount").exists())
        .andExpect(jsonPath("$.foods[*].calorie").exists());
  }

  @Test
  public void addNewCalorieTableReturnsCorrectObject() throws Exception {
    mockMvc.perform(post("/drax")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "\"name\": \"Test\",\n" +
            "\"amount\": 1,\n" +
            "\"calorie\": 1\n" +
            "}")
    )
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.name", is("Test")))
        .andExpect(jsonPath("$.amount", is(1)))
        .andExpect(jsonPath("$.calorie", is(1)));
  }

  @Test
  public void updateFoodReturnsUpdatedValue() throws Exception {
    mockMvc.perform(delete("/drax/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "\"name\": \"Updated\",\n" +
            "\"amount\": 999,\n" +
            "\"calorie\": 999\n" +
            "}")
    )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.foods[0]", is("Updated")))
        .andExpect(jsonPath("$.foods[0]", is(999)))
        .andExpect(jsonPath("$.foods[0]", is(999)));

  }

  @Test
  public void deleteAFoodFromCalorieTableReturnsEmptyCalorieTable() throws Exception {
    mockMvc.perform(delete("/drax/1"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.foods").exists())
        .andExpect(jsonPath("$.foods", hasSize(0)));
  }


}
