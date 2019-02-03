package ru.ajana.admin.api.service;

import java.util.List;
import ru.ajana.admin.model.Role;


/**
 * Интерфейс сервиса для работы с ролями.
 *
 * @author Andrey Kharintsev by 25.01.2018
 */
public interface RoleService {

  /**
   * Возвращает роль пользователя по идентификатору.
   *
   * @param id идентификатор роли.
   * @return роль пользователя
   */
  Role getRole(Long id);

  /**
   * Метод возвращает список ролей по идентификатору пользователя.
   *
   * @param userId идентификатор пользователя
   * @return список ролей пользоваля
   */
  List<Role> getRolesByUserId(Long userId);
}
