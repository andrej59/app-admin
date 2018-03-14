package ru.ajana.admin.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ajana.admin.jpa.entities.UserEntity;

/**
 * Репозиторий пользователя.
 *
 * @author Andrey Kharintsev by 11.02.2018
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> getUserEntityByName(String name);
}
