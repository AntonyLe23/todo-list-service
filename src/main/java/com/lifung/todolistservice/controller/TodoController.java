package com.lifung.todolistservice.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("/owner/{username}")
  public List<TodoItemDto> getToDosByOwner(@PathVariable String username) {
    return todoItemService.getTodoListByOwner(username).stream()
        .map(todoItemMapper::toTodoItemDto)
        .collect(Collectors.toList());
  }

  @GetMapping("/search")
  public Map<String, List<TodoItemDto>> searchToDosByOwner(@RequestParam(name = "owner") String username) {
    return todoItemService.searchTodoItemByOwner(username).stream()
        .map(todoItemMapper::toTodoItemDto)
        .collect(Collectors.groupingBy(TodoItemDto::getOwnerName));
  }
}
