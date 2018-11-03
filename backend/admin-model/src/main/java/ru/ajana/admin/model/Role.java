package ru.ajana.admin.model;

import java.io.Serializable;

/**
 * Роль пользователя.
 *
 * @author Andrey Kharintsev by 10.03.2018
 */
public class Role implements Serializable {

  private Long id;
  private String name;
  private String ident;

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

  public String getIdent() {
    return ident;
  }

  public void setIdent(String ident) {
    this.ident = ident;
  }
}
