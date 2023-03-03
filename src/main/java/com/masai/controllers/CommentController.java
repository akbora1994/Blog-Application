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
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.PostException;
import com.masai.model.Comment;
import com.masai.service.CommentService;


@RestController("/api/posts")
public class CommentController {
	
	@Autowired
	private CommentService commentServ;
	
	
	@PostMapping("/{postId}/comments")
	public ResponseEntity<Comment> createNewComment(@RequestBody Comment comment,@PathVariable("postId") Integer postId) throws PostException {
		Comment cmnt =  commentServ.createNewComment(comment, postId);
		return new ResponseEntity<Comment>(cmnt,HttpStatus.OK);
	}
	
	@PutMapping("/{postId}/comments/{commentId}")
	public ResponseEntity<Comment> updateComment(@RequestBody Comment comment, @PathVariable("postId") Integer postId,@PathVariable("commentId") Integer commentId) throws PostException {
		Comment cmnt =  commentServ.updateComment(comment, commentId, postId);
		return new ResponseEntity<Comment>(cmnt,HttpStatus.OK);
	}
	
	@DeleteMapping("/{postId}/comments/{commentId}")
	public ResponseEntity<String> deleteComments(@PathVariable("postId") Integer postId ,@PathVariable("commentId") Integer commentId) throws PostException {
		String cmnt =  commentServ.deleteComment(commentId, postId);
		return new ResponseEntity<String>(cmnt,HttpStatus.OK);
	}
	
	@GetMapping("/{postId}/comments")
	public ResponseEntity<List<Comment>> getAllComments(@PathVariable("postId") Integer postId) throws PostException {
		List<Comment> cmnt =  commentServ.getAllComments(postId);
		return new ResponseEntity<List<Comment>>(cmnt,HttpStatus.OK);
	}
	
	@GetMapping("/{postId}/comments/{commentId}")
	public ResponseEntity<Comment> getCommntByID(@PathVariable("postId") Integer postId,@PathVariable("commentId") Integer commentId) throws PostException {
		Comment cmnt =  commentServ.getCommentById(commentId, postId);
		return new ResponseEntity<Comment>(cmnt,HttpStatus.OK);
	}
}
