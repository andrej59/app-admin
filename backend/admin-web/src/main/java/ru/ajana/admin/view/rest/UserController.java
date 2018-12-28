package ru.ajana.admin.view.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ajana.admin.api.service.UserService;
import ru.ajana.admin.model.User;

/**
 * Контроллер rest-сервиса пользователей.
 *
 * @author Andrey Kharintsev on 19.03.2018
 */
@RequestMapping("/users")
public class UserController implements UserService {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  @Override
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping(value = "/{id}")
  @Override
  public User getUser(@PathVariable Long id) {
    return userService.getUser(id);
  }

  @PostMapping
  @PutMapping
  @Override
  public User saveUser(@RequestBody User user) {
    return userService.saveUser(user);
  }

  @DeleteMapping(value = "/{id}")
  @Override
  public void deleteUserById(@PathVariable Long id) {
    userService.deleteUserById(id);
  }

  @GetMapping(path = "getUserByName", value = "/{userName}")
  @Override
  public User getUserByName(@PathVariable String userName) {
    return userService.getUserByName(userName);
  }

  @PutMapping(path = "changePassword")
  @Override
  public boolean changePassword(@RequestParam String userName, @RequestParam String oldPassword,
      @RequestParam String newPassword) {
    return userService.changePassword(userName, oldPassword, newPassword);
  }
}
