package com.lifung.todolistservice.service;

import java.util.List;

import com.lifung.todolistservice.dto.TodoItemDto;
import com.lifung.todolistservice.model.TodoItem;

public interface TodoItemService {

  TodoItem createTodoItem(TodoItemDto todoDto);

  List<TodoItem> getTodoListByOwner(String username);

  List<TodoItem> searchTodoItemByOwner(String username);
}
