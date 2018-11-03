package ru.ajana.admin.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ajana.admin.api.service.UserService;
import ru.ajana.admin.jpa.entities.UserEntity;
import ru.ajana.admin.mapper.Mapper;
import ru.ajana.admin.mapper.MapperFactory;
import ru.ajana.admin.mapper.UserMapper;
import ru.ajana.admin.model.User;
import ru.ajana.admin.repository.UserRepository;
import ru.ajana.admin.util.PasswordUtils;

/**
 * Реализация сервиса бизнес логики пользователей.
 *
 * @author Andrey Kharintsev by 29.01.2018
 */
@Service("userService")
public class UserServiceImpl implements UserService {

  private static final MapperFactory mapperFactory = MapperFactory.getInstance();
  private static final Mapper<UserEntity, User> userMapper;

  static {
    userMapper = mapperFactory.createMapper(UserMapper.class);
  }

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll().stream().map(userMapper::mapTo).collect(Collectors.toList());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public User getUserByName(String userName) {
    UserEntity entity = userRepository.getUserEntityByName(userName).orElse(null);
    return userMapper.mapTo(entity);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public User getUser(Long id) {
    UserEntity entity = userRepository.findById(id).orElse(null);
    return userMapper.mapTo(entity);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public User saveUser(User user) {
    if (user == null) {
      return null;
    }

    UserEntity entity;
    if (user.getId() == null) {
      entity = userMapper.mapFrom(user);
      final String salt = PasswordUtils.genSalt();
      entity.setSalt(salt);
      entity.setPassword(PasswordUtils.hashPassword(user.getPassword(), salt));
      entity.setDtCreate(new Date()); //TODO инициализацию вынести в отдельный механизм
      entity = userRepository.saveAndFlush(entity);
    } else {
      entity = userRepository.findById(user.getId()).orElse(null);
    }
    return userMapper.mapTo(entity);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void deleteUserById(Long id) {
    userRepository.deleteById(id);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean changePassword(String userName, String oldPassword, String newPassword) {
    if (userName == null) {
      return false;
    }
    if (oldPassword == null || newPassword == null) {
      return false;
    }
    UserEntity user = userRepository.getUserEntityByName(userName).orElse(null);
    if (user != null) {
      String salt = user.getSalt();
      if (PasswordUtils.checkPassword(user.getPassword(), oldPassword, salt)) {
        String newSalt = PasswordUtils.genSalt();
        user.setSalt(newSalt);
        user.setPassword(PasswordUtils.hashPassword(newPassword, newSalt));
        userRepository.saveAndFlush(user);
        return true;
      }
    }
    return false;
  }
}
