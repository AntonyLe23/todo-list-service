package com.lifung.todolistservice.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<TodoItem> todoItems;

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
