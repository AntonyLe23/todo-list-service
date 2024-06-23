package com.lifung.todolistservice.elasticsearch.model;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Document(indexName = "todo-item")
@Getter
public class TodoItemDoc {

  @Setter
  @Id
  private String id;

  @Setter
  @Field(type = FieldType.Long)
  private Long entityId;

  @Field(type = FieldType.Text)
  private String title;

  @Field(type = FieldType.Text)
  private String description;

  @Setter
  @Field(type = FieldType.Boolean)
  private boolean completed;

  @Field(type = FieldType.Keyword)
  private String username;

  public void setTitle(String title) {
    this.title = title.toLowerCase();
  }

  public void setDescription(String description) {
    this.description = description.toLowerCase();
  }

  public void setUsername(String username) {
    this.username = username.toLowerCase();
  }
}
