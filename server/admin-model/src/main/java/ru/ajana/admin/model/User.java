package ru.ajana.admin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Пользователь приложения.
 *
 * @author Andrey Kharintsev by 29.01.2018
 */
public class User implements Serializable {

  private Long id;
  private String userName;
  private transient String password;
  private transient String salt;
  private String email;
  private Boolean locked;
  private Date createDate;
  private Date lastLoginDate;
  private Set<Role> roles;
  private Set<Group> groups;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getLocked() {
    return locked;
  }

  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getLastLoginDate() {
    return lastLoginDate;
  }

  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public Set<Group> getGroups() {
    return groups;
  }

  public void setGroups(Set<Group> groups) {
    this.groups = groups;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id) &&
        Objects.equals(userName, user.userName) &&
        Objects.equals(email, user.email) &&
        Objects.equals(locked, user.locked) &&
        Objects.equals(createDate, user.createDate) &&
        Objects.equals(lastLoginDate, user.lastLoginDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userName);
  }
}
