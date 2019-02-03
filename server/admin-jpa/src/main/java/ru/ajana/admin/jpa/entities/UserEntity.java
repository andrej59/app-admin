package ru.ajana.admin.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the users database table.
 */
@Entity
@Table(name = "USERS")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "USERS_ID_GENERATOR", sequenceName = "SEQ_USERS")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_ID_GENERATOR")
  private Long id;

  private String email;

  private Boolean enabled;

  private String name;

  private String password;

  private String salt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "DT_CREATE")
  private Date dtCreate;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "DT_UPDATE")
  private Date dtUpdate;

  //bi-directional one-to-one association to UserAccountEntity
//  @OneToOne(mappedBy = "userEntity", fetch = FetchType.LAZY)
//  private UserAccountEntity userAccountEntity;

  @ManyToMany
  @JoinTable(
      name = "USER_ROLES"
      , joinColumns = {
      @JoinColumn(name = "USER_ID")
  }
      , inverseJoinColumns = {
      @JoinColumn(name = "ROLE_ID")
  }
  )
  private List<RoleEntity> roleEntities;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getEnabled() {
    return this.enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSalt() {
    return this.salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

//  public UserAccountEntity getUserAccountEntity() {
//    return this.userAccountEntity;
//  }

//  public void setUserAccountEntity(UserAccountEntity userAccountEntity) {
//    this.userAccountEntity = userAccountEntity;
//  }

  public List<RoleEntity> getRoleEntities() {
    return this.roleEntities;
  }

  public void setRoleEntities(List<RoleEntity> roleEntities) {
    this.roleEntities = roleEntities;
  }

  public Date getDtCreate() {
    return this.dtCreate;
  }

  public void setDtCreate(Date dtCreate) {
    this.dtCreate = dtCreate;
  }

  public Date getDtUpdate() {
    return this.dtUpdate;
  }

  public void setDtUpdate(Date dtUpdate) {
    this.dtUpdate = dtUpdate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserEntity that = (UserEntity) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (dtCreate != null ? !dtCreate.equals(that.dtCreate) : that.dtCreate != null) {
      return false;
    }
    if (dtUpdate != null ? !dtUpdate.equals(that.dtUpdate) : that.dtUpdate != null) {
      return false;
    }
    if (email != null ? !email.equals(that.email) : that.email != null) {
      return false;
    }
    if (enabled != null ? !enabled.equals(that.enabled) : that.enabled != null) {
      return false;
    }
    return name != null ? name.equals(that.name) : that.name == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (dtCreate != null ? dtCreate.hashCode() : 0);
    result = 31 * result + (dtUpdate != null ? dtUpdate.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}