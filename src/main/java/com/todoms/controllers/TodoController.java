package com.todoms.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {
	
//	@Autowired
//	TodoService todoService;
	
	
	@GetMapping("/{username}/todos")
	public String getAllTodos(@PathVariable String username) {
		return "Hello "+username;
	}
	
	/*
	 * @GetMapping("/{username}/todos") public List<Todo> getAllTodos(@PathVariable
	 * String username){ return todoService.getTodobyUsername(username); }
	 * 
	 * @GetMapping("/{username}/todos/{id}") public Todo getTodo(@PathVariable
	 * String username, @PathVariable long id){ return todoService.getTodobyId(id);
	 * }
	 * 
	 * @DeleteMapping("/{username}/todos/{id}") public ResponseEntity<Void>
	 * deleteTodo(
	 * 
	 * @PathVariable String username, @PathVariable long id) {
	 * 
	 * todoService.deleteTodo(id);
	 * 
	 * return ResponseEntity.noContent().build(); }
	 * 
	 * 
	 * @PutMapping("/{username}/todos/{id}") public ResponseEntity<Todo> updateTodo(
	 * 
	 * @PathVariable String username,
	 * 
	 * @PathVariable long id, @RequestBody Todo todo){
	 * 
	 * todo.setUsername(username);
	 * 
	 * Todo todoUpdated = todoService.updateTodo(id,todo);
	 * 
	 * return new ResponseEntity<Todo>(todoUpdated, HttpStatus.ACCEPTED); }
	 * 
	 * @PostMapping("/{username}/todos") public ResponseEntity<Void> createTodo(
	 * 
	 * @PathVariable String username, @RequestBody Todo todo){
	 * 
	 * todo.setId(-1L);
	 * 
	 * Todo createdTodo = todoService.createTodo(todo);
	 * 
	 * //Location //Get current resource url ///{id} URI uri =
	 * ServletUriComponentsBuilder.fromCurrentRequest()
	 * .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
	 * 
	 * return ResponseEntity.created(uri).build(); }
	 */

}
