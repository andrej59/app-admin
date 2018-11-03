package ru.ajana.admin.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the user_accounts database table.
 */
@Entity
@Table(name = "user_accounts")
@NamedQuery(name = "UserAccount.findAll", query = "SELECT u FROM UserAccountEntity u")
public class UserAccountEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "USER_ACCOUNTS_ID_GENERATOR", sequenceName = "SEQ_IDENT")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ACCOUNTS_ID_GENERATOR")
  private long id;

  @Column(name = "account_expired")
  private Boolean accountExpired;

  @Column(name = "credential_expired")
  private Boolean credentialExpired;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "dt_create")
  private Date dtCreate;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "dt_update")
  private Date dtUpdate;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  private Boolean locked;

  @Column(name = "middle_name")
  private String middleName;

  //bi-directional one-to-one association to UserEntity
//  @OneToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "id")
//  private UserEntity userEntity;


  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Boolean getAccountExpired() {
    return this.accountExpired;
  }

  public void setAccountExpired(Boolean accountExpired) {
    this.accountExpired = accountExpired;
  }

  public Boolean getCredentialExpired() {
    return this.credentialExpired;
  }

  public void setCredentialExpired(Boolean credentialExpired) {
    this.credentialExpired = credentialExpired;
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

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Boolean getLocked() {
    return this.locked;
  }

  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  public String getMiddleName() {
    return this.middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

//  public UserEntity getUserEntity() {
//    return this.userEntity;
//  }

//  public void setUserEntity(UserEntity userEntity) {
//    this.userEntity = userEntity;
//  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserAccountEntity that = (UserAccountEntity) o;

    if (id != that.id) {
      return false;
    }
    if (accountExpired != null ? !accountExpired.equals(that.accountExpired)
        : that.accountExpired != null) {
      return false;
    }
    if (credentialExpired != null ? !credentialExpired.equals(that.credentialExpired)
        : that.credentialExpired != null) {
      return false;
    }
    if (dtCreate != null ? !dtCreate.equals(that.dtCreate) : that.dtCreate != null) {
      return false;
    }
    if (dtUpdate != null ? !dtUpdate.equals(that.dtUpdate) : that.dtUpdate != null) {
      return false;
    }
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) {
      return false;
    }
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) {
      return false;
    }
    if (locked != null ? !locked.equals(that.locked) : that.locked != null) {
      return false;
    }
    return middleName != null ? middleName.equals(that.middleName) : that.middleName == null;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (accountExpired != null ? accountExpired.hashCode() : 0);
    result = 31 * result + (credentialExpired != null ? credentialExpired.hashCode() : 0);
    result = 31 * result + (dtCreate != null ? dtCreate.hashCode() : 0);
    result = 31 * result + (dtUpdate != null ? dtUpdate.hashCode() : 0);
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (locked != null ? locked.hashCode() : 0);
    result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
    return result;
  }
}