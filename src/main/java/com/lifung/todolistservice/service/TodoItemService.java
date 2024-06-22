package com.lifung.todolistservice.service;

import com.lifung.todolistservice.model.TodoItem;
import com.lifung.todolistservice.dto.TodoItemDto;

public interface TodoItemService {

  TodoItem createTodoItem(TodoItemDto todoDto);
}
