package com.greenfoxacademy.restoptionals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class GuardianControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void translateToGrootWithParameterReturnsCorrectFieldsAndValues() throws Exception {
    mockMvc.perform(get("/groot?message=somemessage"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.received", is("somemessage")))
        .andExpect(jsonPath("$.translated", is("I am Groot!")));
  }

  @Test
  public void translateToGrootWithoutParameterReturnsError() throws Exception {
    mockMvc.perform(get("/groot"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("I am Groot!")));
  }

  @Test
  public void translateToGrootWithEmptyParameterReturnsCorrectFieldsAndValues() throws Exception {
    mockMvc.perform(get("/groot?message="))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("I am Groot!")));
  }

  @Test
  public void calculateYonduWithParametersReturnsValidValues() throws Exception {
    mockMvc.perform(get("/yondu?distance=100&time=10"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.distance", is(100.0)))
        .andExpect(jsonPath("$.time", is(10.0)))
        .andExpect(jsonPath("$.speed", is(10.0)));
  }

  @Test
  public void calculateYonduWithMissingTimeParameterReturnsError() throws Exception {
    mockMvc.perform(get("/yondu?distance=100"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Some of the parameter is null.")));
  }

  @Test
  public void calculateYonduWithMissingDistanceParameterReturnsError() throws Exception {
    mockMvc.perform(get("/yondu?time=10"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Some of the parameter is null.")));
  }

  @Test
  public void calculateYonduWithDividingZeroReturnsError() throws Exception {
    mockMvc.perform(get("/yondu?distance=100&time=0"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("You can't divide with 0!")));
  }

  @Test
  public void getActualStatusOfCargoReturnsDefaultValues() throws Exception {
    mockMvc.perform(get("/rocket"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.caliber25", is(0)))
        .andExpect(jsonPath("$.caliber30", is(0)))
        .andExpect(jsonPath("$.caliber50", is(0)))
        .andExpect(jsonPath("$.shipstatus", is("empty")))
        .andExpect(jsonPath("$.ready", is(false)));
  }

  @Test
  @DirtiesContext
  public void getActualStatusOfCargoWith40PercentReturnsCorrectValues() throws Exception {
    mockMvc.perform(get("/rocket/fill?caliber=.50&amount=5000"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.shipstatus", is("40%")))
        .andExpect(jsonPath("$.ready", is(false)));
  }

  @Test
  public void getActualStatusOfCargoWith100PercentReturnsCorrectValues() throws Exception {
    mockMvc.perform(get("/rocket/fill?caliber=.50&amount=12500"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.shipstatus", is("full")))
        .andExpect(jsonPath("$.ready", is(true)));
  }

  @Test
  public void getActualStatusOfCargoWithMoreThan100PercentReturnsCorrectValues() throws Exception {
    mockMvc.perform(get("/rocket/fill?caliber=.50&amount=12501"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.shipstatus", is("overloaded")))
        .andExpect(jsonPath("$.ready", is(false)));
  }

  @Test
  public void getActualStatusOfCargoWithMissingParameterCaliberReturnsError() throws Exception {
    mockMvc.perform(get("/rocket/fill?amount=12501"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Missing parameters!")));
  }

  @Test
  public void getActualStatusOfCargoWithMissingParameterAmountReturnsError() throws Exception {
    mockMvc.perform(get("/rocket/fill?caliber=.50"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Missing parameters!")));
  }

  @Test
  public void getActualStatusOfCargoWithInvalidCaliberReturnsError() throws Exception {
    mockMvc.perform(get("/rocket/fill?caliber=.51&amount=12500"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("Invalid caliber type!")));
  }

}
