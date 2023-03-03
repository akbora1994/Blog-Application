package com.masai.service;

import java.util.List;

import com.masai.exception.PostException;
import com.masai.exception.UserException;
import com.masai.model.Post;

public interface PostService {
	
	public Post createNewPost(Post post,Integer userID) throws UserException;
	
	public Post updatePost(Integer postID, Post post) throws PostException;
	
	public String deletePost(Integer postId) throws PostException;
	
	public List<Post> getAllPost(Integer userId) throws UserException;
	
	public Post getPostById(Integer postId) throws PostException;

	
}
