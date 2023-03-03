package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.PostException;
import com.masai.exception.UserException;
import com.masai.model.Post;
import com.masai.model.User;
import com.masai.repository.PostDao;
import com.masai.repository.UserDao;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostDao postDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Post createNewPost(Post post,Integer userId) throws UserException {
		
		Optional<User> user = userDao.findById(userId);
		if(!user.isPresent()) {
			throw new UserException("User doesn't exist!");
		}
		
		User user1 = user.get();
		post.setUser(user.get());
		Post p1 = postDao.save(post);
	
		user1.getPosts().add(p1);
		userDao.save(user1);
		
		return p1;
	}


	@Override
	public Post updatePost(Integer postID, Post post) throws PostException {
		
		Optional<Post> optPost =  postDao.findById(postID);
		if(!optPost.isPresent()) {
			throw new PostException("No post found!");
		}
		
		User user =  optPost.get().getUser();
		post.setUser(optPost.get().getUser());
		
		return postDao.save(post);
	}
	
	@Override
	public String deletePost(Integer postId) throws PostException {
		
		Optional<Post> postOpt =  postDao.findById(postId);
		if(!postOpt.isPresent()) {
			throw new PostException("No post found!");
		}
		
		User user = postOpt.get().getUser();
		user.getPosts().remove(postOpt.get());
		userDao.save(user);
		postDao.delete(postOpt.get());
		
		return "Post deleted!";
	}

	@Override
	public List<Post> getAllPost(Integer userId) throws UserException {
		
		Optional<User> userOpt = userDao.findById(userId);
		
		if(!userOpt.isPresent()) {
			throw new UserException("User not found!");
		}
		return userOpt.get().getPosts();
	}

	@Override
	public Post getPostById(Integer postId) throws PostException {
		
		Optional<Post> opttPost =  postDao.findById(postId);
		if(!opttPost.isPresent()) {
			throw new PostException("No post found!");
		}
		return opttPost.get();
	}
	
}
	
