package ru.ajana.admin.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ajana.admin.api.service.RoleService;
import ru.ajana.admin.jpa.entities.RoleEntity;
import ru.ajana.admin.jpa.entities.UserEntity;
import ru.ajana.admin.mapper.Mapper;
import ru.ajana.admin.mapper.MapperFactory;
import ru.ajana.admin.mapper.RoleMapper;
import ru.ajana.admin.model.Role;
import ru.ajana.admin.repository.RoleRepository;
import ru.ajana.admin.repository.UserRepository;

/**
 * Сервис ролей пользователей.
 *
 * @author Andrey Kharintsev by 10.03.2018
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

  private static final MapperFactory mapperFactory = MapperFactory.getInstance();
  private static final Mapper<RoleEntity, Role> roleMapper;
  private final RoleRepository roleRepository;
  private final UserRepository userRepository;


  static {
    roleMapper = mapperFactory.createMapper(RoleMapper.class);
  }

  @Autowired
  public RoleServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
    this.roleRepository = roleRepository;
    this.userRepository = userRepository;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Role getRole(Long id) {
    return roleMapper.mapTo(roleRepository.findById(id).orElse(null));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Role> getRolesByUserId(Long userId) {
    if (userId == null) {
      return null;
    }
    UserEntity userEntity = userRepository.findById(userId).orElse(null);
    if (userEntity == null) {
      return null;
    }
    List<RoleEntity> roleEntities = userEntity.getRoleEntities();
    return roleEntities.stream().map(roleMapper::mapTo).collect(Collectors.toList());
  }
}
