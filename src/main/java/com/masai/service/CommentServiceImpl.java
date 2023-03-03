package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.PostException;
import com.masai.model.Comment;
import com.masai.model.Post;
import com.masai.repository.PostDao;
import com.masai.repository.CommentDao;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private PostDao postDao;

	@Override
	public Comment getCommentById(Integer commentId, Integer postId) throws PostException {
		
		Optional<Post> optPost =  postDao.findById(postId);
		
		if(!optPost.isPresent()) {
			throw new PostException("No Post found!");
		}
		
		Optional<Comment> comment = commentDao.findById(commentId);
		return comment.get();
	}



	@Override
	public Comment createNewComment(Comment comment, Integer postId) throws PostException {
		
		Optional<Post> optPst =  postDao.findById(postId);
		if(!optPst.isPresent()) {
			throw new PostException("No Post found!");
		}
		
		comment.setPost(optPst.get());
		Comment cmnt1 = commentDao.save(comment);
		
		optPst.get().getComments().add(cmnt1);
		postDao.save(optPst.get());
		
		
		return cmnt1;
	}

	@Override
	public List<Comment> getAllComments(Integer postId) throws PostException {
		
		Optional<Post> allpost =  postDao.findById(postId);
		
		if(!allpost.isPresent()) {
			throw new PostException("No Post found!");
		}
		return allpost.get().getComments();
	}

	@Override
	public String deleteComment(Integer taskId, Integer postId) throws PostException {
		
		Optional<Comment> optCmntt = commentDao.findById(taskId);
		
		if(!optCmntt.isPresent()) {
			throw new PostException("No Comment found!");
		}
		
		Post p = optCmntt.get().getPost();
		p.getComments().remove(optCmntt.get());
		postDao.save(p);
		commentDao.delete(optCmntt.get());
		
		return "Comment Deleted!";
	}

	@Override
	public Comment updateComment(Comment comm, Integer commentId, Integer postId) throws PostException {
		
		Optional<Comment> optCmnt =  commentDao.findById(commentId);
		if(!optCmnt.isPresent()) {
			throw new PostException("No Comment found!");
		}
		
		Post p = optCmnt.get().getPost();
		comm.setPost(p);
		
		return commentDao.save(comm);
	}

	
}
