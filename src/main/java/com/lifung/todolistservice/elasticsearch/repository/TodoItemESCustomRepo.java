package com.lifung.todolistservice.elasticsearch.repository;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.lifung.todolistservice.elasticsearch.model.TodoItemDoc;

@Repository
public interface TodoItemESCustomRepo {
  Set<Long> findByOwner(String username);
}
