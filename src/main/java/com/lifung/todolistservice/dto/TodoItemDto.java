package com.lifung.todolistservice.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TodoItemDto implements Serializable {

  private String title;
  private String description;
  private boolean completed;
  @JsonProperty(value = "owner_name", required = true)
  private String ownerName;

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    return o != null && getClass() == o.getClass();
  }
}
