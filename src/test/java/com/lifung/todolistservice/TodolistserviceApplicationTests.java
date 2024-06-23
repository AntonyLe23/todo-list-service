package com.lifung.todolistservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

import com.lifung.todolistservice.elasticsearch.repository.TodoItemESCustomRepo;
import com.lifung.todolistservice.elasticsearch.repository.TodoItemESRepo;

@SpringBootTest
class TodolistserviceApplicationTests {
	@MockBean
	private TodoItemESCustomRepo todoItemESCustomRepo;

	@MockBean
	private TodoItemESRepo todoItemESRepo;

	@Test
	void contextLoads() {
	}

}
