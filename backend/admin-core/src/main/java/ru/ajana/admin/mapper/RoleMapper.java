package ru.ajana.admin.mapper;

import ru.ajana.admin.jpa.entities.RoleEntity;
import ru.ajana.admin.model.Role;

/**
 * Маппер ролей пользователя.
 *
 * @author Andrey Kharintsev by 10.03.2018
 */
public class RoleMapper implements Mapper<RoleEntity, Role> {


  @Override
  public Role mapTo(RoleEntity entity) {
    Role role = new Role();
    role.setId(entity.getId());
    role.setName(entity.getName());
    role.setIdent(entity.getIdent());
    return role;
  }

  @Override
  public RoleEntity mapFrom(Role role) {
    RoleEntity roleEntity = new RoleEntity();
    roleEntity.setId(role.getId());
    roleEntity.setName(role.getName());
    roleEntity.setIdent(role.getIdent());
    return roleEntity;
  }
}
