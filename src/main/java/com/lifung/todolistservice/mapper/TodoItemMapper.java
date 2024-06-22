package com.lifung.todolistservice.mapper;

import org.springframework.stereotype.Component;

import com.lifung.todolistservice.model.TodoItem;
import com.lifung.todolistservice.dto.TodoItemDto;

@Component
public class TodoItemMapper {

  public TodoItem toTodoItem(TodoItemDto todoDto) {
    TodoItem todoItem = new TodoItem();
    todoItem.setCompleted(todoDto.isCompleted());
    todoItem.setDescription(todoDto.getDescription());
    todoItem.setTitle(todoDto.getTitle());
    return todoItem;
  }

  public TodoItemDto toTodoItemDto(TodoItem todoItem) {
    return TodoItemDto.builder()
        .title(todoItem.getTitle())
        .description(todoItem.getDescription())
        .completed(todoItem.isCompleted())
        .ownerName(todoItem.getUser().getUsername())
        .build();
  }
}
