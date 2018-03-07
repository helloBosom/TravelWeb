package com.cissst.software.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.dao.CommentDao;
import com.cissst.software.model.Comment;
import com.cissst.software.service.ICommentService;

@Service
public class ConmmentService implements ICommentService {
	
	@Autowired
	protected CommentDao commentdao;
	@Override
	public void addcomment(Comment comment) {
		
		commentdao.save(comment);
	}
	@Override
	public void deletecomment(Comment commetn) {
		
		commentdao.remove(commetn);
	}
	@Override
	public Comment getcomment(int id) {
		
		return commentdao.get(id);
	}
	@Override
	public void updatecomment(Comment comment) {
		commentdao.update(comment);
		
	}
	@Override
	public List<Object> show(int spaceId) {
		
		return commentdao.show(spaceId);
	}

}
