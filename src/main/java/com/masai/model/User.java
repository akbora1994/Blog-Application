package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userID;
	
	@NotNull
	@NotBlank(message = "username is mandatory")
	private String userName;
	
	@NotNull
	@NotBlank
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	@Size(min=10,max=10,message = "Mobile number should be 10 digit")
	private String mobile;
	
	@OneToMany
	@JsonIgnore
	private List<Post> posts = new ArrayList<>();


}
