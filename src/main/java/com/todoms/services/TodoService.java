package com.todoms.services;

import java.util.List;
import java.util.Optional;

import com.todoms.model.Todo;

public interface TodoService {
	
	List<Todo> getAllTodos();

	List<Todo> getTodobyUsername(String username);
	
	Todo getTodobyId(Long Id);

	Todo createTodo(Todo todo);

	Todo updateTodo(Long Id, Todo todoUpdate);

	void deleteTodo(Long Id);

}
