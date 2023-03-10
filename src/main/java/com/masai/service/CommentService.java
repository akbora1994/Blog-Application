package com.masai.service;

import java.util.List;

import com.masai.exception.PostException;
import com.masai.model.Comment;

public interface CommentService {
	
	public Comment createNewComment(Comment task, Integer postId) throws PostException;
	
	public Comment updateComment(Comment task,Integer taskId,Integer postId) throws PostException;
	
	public String deleteComment(Integer taskId, Integer postId) throws PostException;
	
	public List<Comment> getAllComments(Integer postId) throws PostException;
	
	public Comment getCommentById(Integer taskId, Integer postId) throws PostException;
	
	
}
