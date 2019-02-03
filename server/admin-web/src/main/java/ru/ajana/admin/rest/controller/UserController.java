package ru.ajana.admin.rest.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import io.swagger.annotations.Api;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ajana.admin.api.service.UserService;
import ru.ajana.admin.model.User;

/**
 * Контроллер rest-сервиса пользователей.
 *
 * @author Andrey Kharintsev on 19.03.2018
 */
@RestController
@RequestMapping(path = "/v1/users", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
@Api(value = "API Admin", description = "Service Admin Application")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity getUser(@PathVariable Long id) {
    return ResponseEntity.of(Optional.of(userService.getUser(id)));
  }

  @GetMapping(path = "getUserByName/{userName}")
  public ResponseEntity getUserByName(@PathVariable String userName) {
    return ResponseEntity.of(Optional.of(userService.getUserByName(userName)));
  }

  @PostMapping
  public ResponseEntity createUser(@RequestBody User user) {
    return ResponseEntity.ok(userService.saveUser(user));
  }

  @PutMapping
  public ResponseEntity updateUser(@RequestBody User user) {
    return ResponseEntity.of(Optional.of(userService.saveUser(user)));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity deleteUserById(@PathVariable Long id) {
    userService.deleteUserById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping(path = "changePassword")
  public ResponseEntity changePassword(@RequestParam String userName,
      @RequestParam String oldPassword,
      @RequestParam String newPassword) {
    return ResponseEntity.ok(userService.changePassword(userName, oldPassword, newPassword));
  }
}
