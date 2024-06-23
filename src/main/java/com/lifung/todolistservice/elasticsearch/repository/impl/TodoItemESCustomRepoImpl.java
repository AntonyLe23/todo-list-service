package com.lifung.todolistservice.elasticsearch.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import com.lifung.todolistservice.elasticsearch.model.TodoItemDoc;
import com.lifung.todolistservice.elasticsearch.repository.TodoItemESCustomRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoItemESCustomRepoImpl implements TodoItemESCustomRepo {

  private final ElasticsearchTemplate elasticsearchTemplate;

  @Override
  public Set<Long> findByOwner(String username) {
    Criteria criteria = new Criteria("username").contains(username);
    CriteriaQuery nativeQuery = CriteriaQuery.builder(criteria).build();
    SearchHits<TodoItemDoc> searchHits = elasticsearchTemplate.search(nativeQuery, TodoItemDoc.class);
    return searchHits.stream()
        .map(SearchHit::getContent)
        .map(TodoItemDoc::getEntityId)
        .collect(Collectors.toSet());
  }
}
