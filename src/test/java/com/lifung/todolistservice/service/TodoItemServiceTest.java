package com.lifung.todolistservice.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.lifung.todolistservice.dto.TodoItemDto;
import com.lifung.todolistservice.elasticsearch.repository.TodoItemESCustomRepo;
import com.lifung.todolistservice.elasticsearch.repository.TodoItemESRepo;
import com.lifung.todolistservice.elasticsearch.service.TodoItemESService;
import com.lifung.todolistservice.exception.BaseException;
import com.lifung.todolistservice.exception.ErrorCode;
import com.lifung.todolistservice.mapper.TodoItemMapper;
import com.lifung.todolistservice.model.TodoItem;
import com.lifung.todolistservice.repository.TodoItemRepository;
import com.lifung.todolistservice.service.impl.TodoItemServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TodoItemServiceTest {

  @MockBean
  private TodoItemESCustomRepo todoItemESCustomRepo;

  @MockBean
  private TodoItemESRepo todoItemESRepo;

  @InjectMocks
  private TodoItemServiceImpl todoItemService;

  @Mock
  private TodoItemRepository todoItemRepository;

  @Mock
  private TodoItemMapper todoItemMapper;

  @Mock
  private UserService userService;

  @Mock
  private TodoItemESService todoItemESService;

  @Test
  public void should_create_todo_item_success() {
    TodoItemDto todoItemDto = new TodoItemDto("title", "description", false, "username");

    TodoItem expected = new TodoItem();
    expected.setTitle(todoItemDto.getTitle());
    expected.setDescription(todoItemDto.getDescription());

    TodoItem savedItem = todoItemService.createTodoItem(todoItemDto);

    Assertions.assertThat(savedItem).isNotNull();
    Assertions.assertThat(savedItem.getTitle()).isEqualTo(expected.getTitle());
    Assertions.assertThat(savedItem.getDescription()).isEqualTo(expected.getDescription());
    Assertions.assertThat(savedItem.getUser()).isNotNull();
    Assertions.assertThat(savedItem.getUser().getUsername()).isEqualTo(todoItemDto.getOwnerName());
  }

  @Test
  public void should_create_todo_item_fail_bc_no_owner() {
    TodoItemDto todoItemDto = new TodoItemDto("title", "description", false, "");

    BaseException exception = assertThrows(BaseException.class, () -> todoItemService.createTodoItem(todoItemDto));

    Assertions.assertThat(exception.getError()).isNotNull();
    Assertions.assertThat(exception.getError()).isEqualTo(ErrorCode.USERNAME_IS_BLANK);

  }
}
