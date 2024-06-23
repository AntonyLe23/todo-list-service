package com.lifung.todolistservice.elasticsearch.service;

import java.util.Set;

import com.lifung.todolistservice.model.TodoItem;

public interface TodoItemESService {

  void indexNewTodoItem(TodoItem todoItem);

  Set<Long> searchTodoItemByOwner(String username);
}
