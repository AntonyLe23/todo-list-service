package com.lifung.todolistservice.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.lifung.todolistservice.elasticsearch.model.TodoItemDoc;

public interface TodoItemESRepo extends ElasticsearchRepository<TodoItemDoc, String> {

}
