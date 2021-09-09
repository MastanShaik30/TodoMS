package com.todoms.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "todo")
public class Todo {
	
	@Id
	@Column(name = "id", nullable = false)
	@NonNull
	@GeneratedValue
	private Long id;
	
	@Column(name = "username", nullable = false)
	@NonNull
	@NotEmpty(message = "'username' field was empty")
	private String username;
	
	@Column(name = "description", nullable = false)
	@NonNull
	@NotEmpty(message = "'description' field was empty")
	private String description;
	
	@Column(name = "targetDate", nullable = false)
	@NonNull
	@NotNull(message = "'targetDate' field was empty")
	private Date targetDate;
	
	@Column(name = "isDone", nullable = true)
	private boolean isDone;


}
