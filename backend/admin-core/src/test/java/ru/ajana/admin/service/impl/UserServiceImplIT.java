package ru.ajana.admin.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ajana.admin.AbstractIntegrationTest;
import ru.ajana.admin.api.service.UserService;
import ru.ajana.admin.model.User;
import ru.ajana.admin.util.PasswordUtils;

/**
 * Интеграционный тест сервиса пользователей.
 *
 * @author Andrey Kharintsev by 11.02.2018
 */

public class UserServiceImplIT extends AbstractIntegrationTest {

  @Autowired
  private UserService userService;

  @Test
  public void testGetUser() {
    User user1 = userService.getUser(-123L);
    assertNull(user1);

    User user2 = userService.getUser(1L);
    assertNotNull(user2);

    List<User> userList = userService.getAllUsers();

    assertTrue(userList.size() > 0);
  }

  @Test
  public void testGetUserByName() {
    User admin = userService.getUserByName("admin");
    assertNotNull(admin);
    assertNotNull("admin", admin.getName());
  }

  @Test
  public void testGetAllUsers() {
    List<User> userList = userService.getAllUsers();
    assertTrue(userList.size() > 0);
  }

  @Test
  public void testSaveUser() {
    User userExpected = generateObject(User.class);
    userExpected.setId(null);
    User actualUser = userService.saveUser(userExpected);

    assertNotNull(actualUser);
    assertEquals(userExpected.getName(), actualUser.getName());
    assertEquals(userExpected.getEmail(), actualUser.getEmail());

    String hashPassword = PasswordUtils
        .hashPassword(userExpected.getPassword(), actualUser.getSalt());
    assertEquals(hashPassword, actualUser.getPassword());
    assertEquals(userExpected.getEnabled(), actualUser.getEnabled());
  }

  @Test
  public void testDeleteUser() {
    User user1 = userService.getUser(1L);
    assertNotNull(user1);
    userService.deleteUserById(1L);

    User user2 = userService.getUser(1L);
    assertNull(user2);
  }

  @Test
  public void testCheckPassword() {
    boolean change = userService.changePassword(null, "123", "123");
    assertFalse(change);
    change = userService.changePassword("admin", null, "123");
    assertFalse(change);
    change = userService.changePassword("admin", "123", null);
    assertFalse(change);

    User userExpected = generateObject(User.class);
    userExpected.setId(null);
    userExpected.setSalt(PasswordUtils.genSalt());
    String oldPassword = "admin";
    userExpected.setPassword(oldPassword);
    User actualUser = userService.saveUser(userExpected);
    // Пароль не совпадает со старым
    change = userService
        .changePassword(actualUser.getName(), oldPassword + "_1", "123");
    assertFalse(change);
    // Пароль совпадавет со старым
    change = userService
        .changePassword(actualUser.getName(), oldPassword, "123");
    assertTrue(change);
  }
}
