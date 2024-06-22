package com.lifung.todolistservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

  @Column(name = "username")
  private String username;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    User userDao = (User) o;
    return getId().equals(userDao.getId()) || getUsername().equals(userDao.getUsername());
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
