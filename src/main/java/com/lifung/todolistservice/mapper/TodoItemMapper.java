package com.lifung.todolistservice.mapper;

import com.lifung.todolistservice.dto.TodoItemDto;
import com.lifung.todolistservice.model.TodoItem;

public class TodoItemMapper {

  public static TodoItem toTodoItem(TodoItemDto todoDto) {
    TodoItem todoItem = new TodoItem();
    todoItem.setCompleted(todoDto.isCompleted());
    todoItem.setDescription(todoDto.getDescription());
    todoItem.setTitle(todoDto.getTitle());
    return todoItem;
  }

  public static TodoItemDto toTodoItemDto(TodoItem todoItem) {
    return TodoItemDto.builder()
        .title(todoItem.getTitle())
        .description(todoItem.getDescription())
        .completed(todoItem.isCompleted())
        .ownerName(todoItem.getUser().getUsername())
        .build();
  }
}
