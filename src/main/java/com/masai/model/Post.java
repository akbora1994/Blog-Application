package com.masai.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	
	@NotNull
	@Size(min=2, message = "Minimum size should be 20")
	private String title;
	
	@NotNull
	@Size(min=10, message = "Minimum size should be 10")
	private String description;
	
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	
	@JsonIgnore
	@OneToMany
	private List<Comment> comments = new ArrayList<>();
	
	
	
}
