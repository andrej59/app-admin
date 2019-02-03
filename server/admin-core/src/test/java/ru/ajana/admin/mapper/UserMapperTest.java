package ru.ajana.admin.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import ru.ajana.admin.AbstractTest;
import ru.ajana.admin.core.mapper.Mapper;
import ru.ajana.admin.core.mapper.UserMapper;
import ru.ajana.admin.jpa.entities.UserEntity;
import ru.ajana.admin.model.User;

/**
 * Тест маппера пользователя {@link UserMapper}.
 *
 * @author Andrey Kharintsev by 11.02.2018
 */
public class UserMapperTest extends AbstractTest {

  private static final Mapper<UserEntity, User> userMapper;


  static {
    userMapper = MAPPER_FACTORY.createMapper(UserMapper.class);
  }

  @Test
  public void mapTo() throws Exception {
    UserEntity entity = generateObject(UserEntity.class);
    User user = userMapper.mapTo(entity);
    checkMapUser(entity, user);
  }

  @Test
  public void mapFrom() throws Exception {
    User user = generateObject(User.class);
    UserEntity entity = userMapper.mapFrom(user);
    checkMapUser(entity, user);
  }

  private void checkMapUser(UserEntity entity, User user) {
    assertEquals(entity.getId(), user.getId());
    assertEquals(entity.getName(), user.getUserName());
    assertEquals(entity.getPassword(), user.getPassword());
    assertEquals(entity.getEmail(), user.getEmail());
    assertEquals(entity.getEnabled(), user.getLocked());
  }
}