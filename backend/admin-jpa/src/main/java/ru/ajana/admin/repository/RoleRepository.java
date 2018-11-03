package ru.ajana.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ajana.admin.jpa.entities.RoleEntity;

/**
 * Репозиторий роли пользователей.
 *
 * @author Andrey Kharintsev by 10.03.2018
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
