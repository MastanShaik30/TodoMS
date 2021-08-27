//package com.todoms.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.HttpClientErrorException;
//
//import com.todoms.exceptions.TodoNotFoundException;
//import com.todoms.model.Todo;
//import com.todoms.repository.TodoJpaRepo;
//
//
//@Service
//public class TodoServiceImpl implements TodoService{
//	
//	@Autowired
//	TodoJpaRepo todoJpaRepo;
//
//	@Override
//	public List<Todo> getAllTodos() {
//		return todoJpaRepo.findAll();
//	}
//
//	@Override
//	public List<Todo> getTodobyUsername(String username) {
//		return todoJpaRepo.findByUsername(username);
//	}
//	
//	@Override
//	public Todo getTodobyId(Long id) {
//
//		Optional<Todo> op = todoJpaRepo.findById(id);
//
//		if (!op.isPresent()) {
//			throw new TodoNotFoundException("Todo with Id (" + id + ") not found!");
//		}
//		return todoJpaRepo.findById(id).get();
//		
//	}
//
//	@Override
//	public Todo createTodo(Todo newTodo) {
//		return todoJpaRepo.save(newTodo);
//	}
//
//	@Override
//	public Todo updateTodo(Long id, Todo todoUpdate) {
//
//		if (!id.equals(todoUpdate.getId())) {
//			throw new HttpClientErrorException(HttpStatus.CONFLICT, "Id in URI does not match todo Id to update");
//		}
//
//		Optional<Todo> op = todoJpaRepo.findById(id);
//
//		if (!op.isPresent()) {
//			throw new TodoNotFoundException("Todo with Id (" + id + ") not found!");
//		}
//		Todo orginalTodo = op.get();
//
//		BeanUtils.copyProperties(todoUpdate, orginalTodo);
//
//		return todoJpaRepo.save(orginalTodo);
//	}
//
//	@Override
//	public void deleteTodo(Long id) {
//
//		Optional<Todo> todo = todoJpaRepo.findById(id);
//
//		if (!todo.isPresent()) {
//			throw new TodoNotFoundException("Todo with Id (" + id + ") not found!");
//		}
//
//		todoJpaRepo.delete(todo.get());
//	}
//
//}
