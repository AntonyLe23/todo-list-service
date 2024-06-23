package com.lifung.todolistservice.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.lifung.todolistservice.dto.TodoItemDto;
import com.lifung.todolistservice.elasticsearch.service.TodoItemESService;
import com.lifung.todolistservice.exception.BaseException;
import com.lifung.todolistservice.exception.ErrorCode;
import com.lifung.todolistservice.mapper.TodoItemMapper;
import com.lifung.todolistservice.model.TodoItem;
import com.lifung.todolistservice.model.User;
import com.lifung.todolistservice.repository.TodoItemRepository;
import com.lifung.todolistservice.service.TodoItemService;
import com.lifung.todolistservice.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoItemServiceImpl implements TodoItemService {

  private final TodoItemRepository todoItemRepository;
  private final UserService userService;
  private final TodoItemMapper todoItemMapper;
  private final TodoItemESService todoItemESService;

  @Override
  public TodoItem createTodoItem(TodoItemDto todoDto) {
    if (StringUtils.isNotBlank(todoDto.getOwnerName())) {
      TodoItem todoItem = todoItemMapper.toTodoItem(todoDto);

      Optional<User> userOpt = userService.findByUsername(todoDto.getOwnerName());
      if (userOpt.isPresent()) {
        todoItem.setUser(userOpt.get());
      } else {
        User userDao = new User();
        userDao.setUsername(todoDto.getOwnerName());
        todoItem.setUser(userDao);
      }

      todoItemRepository.save(todoItem);
      todoItemESService.indexNewTodoItem(todoItem);
      return todoItem;
    } else {
      throw new BaseException("Username is required", ErrorCode.USERNAME_IS_BLANK);
    }
  }

  @Override
  public List<TodoItem> getTodoListByOwner(String username) {
    Optional<User> userOpt = userService.findByUsername(username);
    return userOpt.isPresent() ?
        userOpt.get().getTodoItems() : Collections.emptyList();
  }

  @Override
  public List<TodoItem> searchTodoItemByOwner(String username) {
    Set<Long> todoIds = todoItemESService.searchTodoItemByOwner(username);
    return todoItemRepository.findAllById(todoIds);
  }
}
