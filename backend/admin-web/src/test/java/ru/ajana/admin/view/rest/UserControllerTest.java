package ru.ajana.admin.view.rest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ajana.admin.rest.controller.UserController;

/**
 * @author Andrey Kharintsev on 10.04.2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

  @Autowired
  private UserController controller;

  @Test
  public void contexLoads() throws Exception {
    assertNotNull(controller);
  }

}