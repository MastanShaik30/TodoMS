package com.todoms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.sql.Date;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "user")
public class UserModel {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private long id;
	@Column
	@NonNull
	private String username;
	@Column
	@NonNull
	private String password;

}