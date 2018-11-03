package ru.ajana.admin.view;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.ajana.admin.view.rest.UserController;

/**
 * @author Andrey Kharintsev on 10.04.2018
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class WebLayerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldReturnDefaultMessage() throws Exception {
    this.mockMvc.perform(get("/users"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello World")));
  }
}
