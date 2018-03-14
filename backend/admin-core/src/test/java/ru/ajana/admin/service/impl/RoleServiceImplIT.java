package ru.ajana.admin.service.impl;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import ru.ajana.admin.AbstractIntegrationTest;
import ru.ajana.admin.api.service.RoleService;
import ru.ajana.admin.model.Role;

/**
 * Интеграционный тест сервиса ролей пользователя.
 *
 * @author Andrey Kharintsev by 10.03.2018
 */

public class RoleServiceImplIT extends AbstractIntegrationTest {

  @Autowired
  private RoleService roleService;

  @Test
  public void testGetRole() {
    Role role = roleService.getRole(4L);
    assertNotNull(role);
  }

  @Test
  public void testGetRolesByUserId() {
    List<Role> roles = roleService.getRolesByUserId(null);
    assertNull(roles);
    roles = roleService.getRolesByUserId(-1L);
    assertNull(roles);

    roles = roleService.getRolesByUserId(3L);
    assertNotNull(roles.size() == 0);
  }
}