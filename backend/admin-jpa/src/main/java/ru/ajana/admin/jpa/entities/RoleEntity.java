package ru.ajana.admin.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the roles database table.
 */
@Entity
@Table(name = "ROLES")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM RoleEntity r")
public class RoleEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "ROLES_ID_GENERATOR", sequenceName = "SEQ_IDENT")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_ID_GENERATOR")
  private Long id;

  private String ident;

  private String name;

  //bi-directional many-to-many association to GroupEntity
//  @ManyToMany
//  @JoinTable(
//      name = "role_groups"
//      , joinColumns = {
//      @JoinColumn(name = "role_id")
//  }
//      , inverseJoinColumns = {
//      @JoinColumn(name = "group_id")
//  }
//  )
//  private List<GroupEntity> groupEntities;

  //bi-directional many-to-many association to UserEntity
  //@ManyToMany(mappedBy = "ROLES")
  //private List<UserEntity> userEntities;

  public RoleEntity() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIdent() {
    return this.ident;
  }

  public void setIdent(String ident) {
    this.ident = ident;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

//  public List<GroupEntity> getGroupEntities() {
//    return this.groupEntities;
//  }

//  public void setGroupEntities(List<GroupEntity> groupEntities) {
//    this.groupEntities = groupEntities;
//  }

//  public List<UserEntity> getUserEntities() {
//    return this.userEntities;
//  }
//
//  public void setUserEntities(List<UserEntity> userEntities) {
//    this.userEntities = userEntities;
//  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    RoleEntity that = (RoleEntity) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (ident != null ? !ident.equals(that.ident) : that.ident != null) {
      return false;
    }
    return name != null ? name.equals(that.name) : that.name == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (ident != null ? ident.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}