package ru.ajana.admin.mapper;

import ru.ajana.admin.jpa.entities.UserEntity;
import ru.ajana.admin.model.User;

/**
 * Маппер пользователя.
 *
 * @author Andrey Kharintsev by 11.02.2018
 */
public class UserMapper implements Mapper<UserEntity, User> {

  @Override
  public User mapTo(final UserEntity entity) {
    if (entity == null) {
      return null;
    }
    final User user = new User();
    user.setId(entity.getId());
    user.setName(entity.getName());
    user.setEmail(entity.getEmail());
    user.setEnabled(entity.getEnabled());
    user.setPassword(entity.getPassword());
    user.setSalt(entity.getSalt());
    return user;
  }

  @Override
  public UserEntity mapFrom(User user) {
    if (user == null) {
      return null;
    }
    final UserEntity entity = new UserEntity();
    entity.setId(user.getId());
    entity.setName(user.getName());
    entity.setPassword(user.getPassword());
    entity.setSalt(user.getSalt());
    entity.setEmail(user.getEmail());
    entity.setEnabled(user.getEnabled());
    return entity;
  }
}
