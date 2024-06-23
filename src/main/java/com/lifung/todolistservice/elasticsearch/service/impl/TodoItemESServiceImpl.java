package com.lifung.todolistservice.elasticsearch.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.lifung.todolistservice.elasticsearch.model.TodoItemDoc;
import com.lifung.todolistservice.elasticsearch.repository.TodoItemESCustomRepo;
import com.lifung.todolistservice.elasticsearch.repository.TodoItemESRepo;
import com.lifung.todolistservice.elasticsearch.service.TodoItemESService;
import com.lifung.todolistservice.model.TodoItem;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoItemESServiceImpl implements TodoItemESService {

  private final TodoItemESRepo todoItemESRepo;
  private final TodoItemESCustomRepo todoItemESCustomRepo;

  @Override
  public void indexNewTodoItem(TodoItem todoItem) {
    TodoItemDoc doc = new TodoItemDoc();
    doc.setEntityId(todoItem.getId());
    doc.setTitle(todoItem.getTitle());
    doc.setDescription(todoItem.getDescription());

    if (Objects.nonNull(todoItem.getUser())) {
      doc.setUsername(todoItem.getUser().getUsername());
    }
    todoItemESRepo.save(doc);
  }

  @Override
  public Set<Long> searchTodoItemByOwner(String username) {
    return todoItemESCustomRepo.findByOwner(username);
  }

}
