package ru.ajana.admin.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Роль пользователя.
 *
 * @author Andrey Kharintsev by 10.03.2018
 */
public class Role implements Serializable {

  private Long id;
  private String name;
  private String code;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Role role = (Role) o;
    return Objects.equals(id, role.id) &&
        Objects.equals(name, role.name) &&
        Objects.equals(code, role.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code);
  }
}
