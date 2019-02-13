package ru.ajana.admin.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import ru.ajana.admin.AbstractTest;
import ru.ajana.admin.core.mapper.Mapper;
import ru.ajana.admin.core.mapper.RoleMapper;
import ru.ajana.admin.jpa.entities.RoleEntity;
import ru.ajana.admin.model.Role;

/**
 * Тест маппера роли пользователей {@link RoleMapper}.
 *
 * @author Andrey Kharintsev by 11.03.2018
 */
public class RoleMapperTest extends AbstractTest {

  private static final Mapper<RoleEntity, Role> roleMapper;

  static {
    roleMapper = MAPPER_FACTORY.createMapper(RoleMapper.class);
  }

  @Test
  public void mapTo() throws Exception {
    RoleEntity entity = generateObject(RoleEntity.class);
    Role user = roleMapper.mapTo(entity);
    checkMapRole(entity, user);
  }

  @Test
  public void mapFrom() throws Exception {
    Role role = generateObject(Role.class);
    RoleEntity entity = roleMapper.mapFrom(role);
    checkMapRole(entity, role);
  }

  private void checkMapRole(RoleEntity entity, Role role) {
    assertEquals(entity.getId(), role.getId());
    assertEquals(entity.getName(), role.getName());
    assertEquals(entity.getIdent(), role.getCode());
  }
}