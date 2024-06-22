package com.lifung.todolistservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifung.todolistservice.model.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
