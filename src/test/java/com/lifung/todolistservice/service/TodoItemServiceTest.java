package com.lifung.todolistservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.lifung.todolistservice.dto.TodoItemDto;
import com.lifung.todolistservice.elasticsearch.repository.TodoItemESCustomRepo;
import com.lifung.todolistservice.elasticsearch.repository.TodoItemESRepo;
import com.lifung.todolistservice.mapper.TodoItemMapper;
import com.lifung.todolistservice.model.TodoItem;
import com.lifung.todolistservice.repository.TodoItemRepository;
import com.lifung.todolistservice.service.impl.TodoItemServiceImpl;

@SpringBootTest
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

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void should_create_todo_item_success() {
    TodoItemDto todoItemDto = TodoItemDto.builder()
        .title("title")
        .description("description")
        .ownerName("Owner_01")
        .build();

    TodoItem expected = new TodoItem();
    expected.setTitle(todoItemDto.getTitle());
    expected.setDescription(todoItemDto.getDescription());

    Mockito.when(todoItemMapper.toTodoItem(ArgumentMatchers.any()))
        .thenReturn(expected);

    TodoItem savedItem = todoItemService.createTodoItem(todoItemDto);
    savedItem.getUser();
  }
}
