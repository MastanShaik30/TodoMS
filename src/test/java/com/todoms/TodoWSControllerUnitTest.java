package com.todoms;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todoms.controllers.TodoController;
import com.todoms.model.Todo;
import com.todoms.services.TodoService;




@WebMvcTest(TodoController.class)
public class TodoWSControllerUnitTest {
	
	//MockMvc is autowired so WebApplicationContext provides an instance of mockMvc
	@Autowired
	MockMvc mockMvc;
	
	//Object Mapper to converts Object to JSON
	@Autowired
	ObjectMapper objectMapper;
	
	//Mocking the service Layer
	@MockBean
	TodoService todoService;
	
	@Test
	public void getAllTodosTestWithStatusOk() throws Exception{
		List<Todo> todoList = new ArrayList<Todo>();
		todoList.add(new Todo(Long.valueOf(1), "Mastan", "Testing Mockito", Date.valueOf("2015-03-31"), true));
		todoList.add(new Todo(Long.valueOf(2), "Mastan", "Testing Mockito 1", Date.valueOf("2015-04-30"), true));
		
		
		String username="Mastan";
		Mockito.when(todoService.getTodobyUsername(username)).thenReturn(todoList);
		
		
		mockMvc.perform(MockMvcRequestBuilders.get("/todos/"+username+"/todos").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].description", is("Testing Mockito")))
				.andExpect(jsonPath("$[1].id", is(2)))
				.andExpect(jsonPath("$[1].description", is("Testing Mockito 1")));
	}
	
	@Test
	public void getTodobyUsernameandIdWithStatusOk() throws Exception{
		Todo todo = new Todo(Long.valueOf(1), "Mastan", "Testing Mockito", Date.valueOf("2015-03-31"), true);
		
		Long id = (long) 1;
		String username = "Mastan";
		
		Mockito.when(todoService.getTodobyId(id)).thenReturn(todo);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/todos/"+username+"/todos/"+id).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username",is("Mastan")))
				.andExpect(jsonPath("$.description", is("Testing Mockito")));
				
		
	}
	
	
	@Test
	public void deleteTodobyIdwith204Status() throws Exception{
		Long Id = (long)1;
		String username = "Mastan";
		
		TodoService todoSpy = Mockito.spy(todoService);
		Mockito.doNothing().when(todoSpy).deleteTodo(Id);
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/todos/"+username+"/todos/"+Id).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
		verify(todoService,times(1)).deleteTodo(Id);
		
		
	}
	
	
	
}
