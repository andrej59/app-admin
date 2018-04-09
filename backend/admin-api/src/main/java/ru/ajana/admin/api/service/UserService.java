package ru.ajana.admin.api.service;

import java.util.List;
import ru.ajana.admin.model.User;

/**
 * Интерфейс сервиса пользователей.
 *
 * @author Andrey Kharintsev by 25.01.2018
 */
public interface UserService {

  /**
   * Возвращает всех пользователей приложения.
   *
   * @return список пользователей приложения
   */
  List<User> getAllUsers();

  /**
   * Возвращает пользователя приложения по идентификатору.
   *
   * @param id идентификатор пользователя
   * @return пользователь приложения
   */
  User getUser(Long id);

  /**
   * Сохраняет пользователя приложения, если пользователь не существует создаёт нового.
   *
   * @param user пользователь приложения
   */
  User saveUser(User user);

  /**
   * Удаляет пользователя по его идентификатору.
   *
   * @param id идентификатор пользователя
   */
  void deleteUserById(Long id);

  /**
   * Возвращает пользователя приложения по его имени.
   *
   * @param userName имя пользователя приложения
   * @return пользователь приложения
   */
  User getUserByName(String userName);

  /**
   * Выполняет изменение пароля пользователя.
   *
   * @param userName имя пользователя
   * @param oldPassword старый пароль
   * @param newPassword новый пароль
   * @return {@code true} - пароль успешно изменен, {@code false} - при изменении пароля произошла
   * ошибка
   */
  boolean changePassword(String userName, String oldPassword, String newPassword);
}
