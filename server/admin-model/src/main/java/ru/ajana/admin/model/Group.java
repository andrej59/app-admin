package ru.ajana.admin.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * Группа пользоватлей.
 *
 * @author Andrey Kharintsev on 11.02.2019
 */
public class Group implements Serializable {

  private Long id;
  private String name;

  private Set<Role> roles;

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

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return Objects.equals(id, group.id) &&
        Objects.equals(name, group.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
