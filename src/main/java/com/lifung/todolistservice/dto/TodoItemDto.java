package com.lifung.todolistservice.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TodoItemDto implements Serializable {

  private String title;
  private String description;
  private boolean completed;
  @JsonProperty(value = "owner_name", required = true)
  private String ownerName;
}
