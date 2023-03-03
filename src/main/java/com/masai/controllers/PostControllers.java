package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.PostException;
import com.masai.exception.UserException;
import com.masai.model.Post;
import com.masai.service.PostService;


@RestController("/api")
public class PostControllers {

	@Autowired
	private PostService postService;
	
	@PostMapping("/posts/{id}")
	public ResponseEntity<Post> createNewPost(@RequestBody Post post,@PathVariable("id") Integer userId) throws UserException {
		Post pst =  postService.createNewPost(post, userId);
		return new ResponseEntity<Post>(pst,HttpStatus.OK);
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updatePost(@RequestBody Post post,@PathVariable("id") Integer postId) throws UserException, PostException {
		Post pst =  postService.updatePost(postId, post);
		return new ResponseEntity<Post>(pst,HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<String> deletePost(@PathVariable("id") Integer postId) throws UserException, PostException {
		String msg =  postService.deletePost(postId);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getAllPost(Integer userId) throws UserException {
		List<Post> pstList =  postService.getAllPost(userId);
		return new ResponseEntity<List<Post>>(pstList,HttpStatus.OK);
	}

	
	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostByID(@PathVariable("id") Integer postID) throws UserException, PostException {
		Post pst =  postService.getPostById(postID);
		return new ResponseEntity<Post>(pst,HttpStatus.OK);
	}
	
	
}
