package com.lifung.todolistservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifung.todolistservice.dto.TodoItemDto;
import com.lifung.todolistservice.mapper.TodoItemMapper;
import com.lifung.todolistservice.service.TodoItemService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/todos")
@AllArgsConstructor
public class TodoController {

  private final TodoItemService todoItemService;
  private final TodoItemMapper todoItemMapper;

  @PostMapping
  public TodoItemDto createTodo(@RequestBody TodoItemDto todoDto) {
    return todoItemMapper.toTodoItemDto(todoItemService.createTodoItem(todoDto));
  }
}
