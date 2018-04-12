package fun.peri.service.impl;

import java.util.List;

import fun.peri.dao.CommentDao;
import fun.peri.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.peri.model.Comment;

@Service
public class CommentServiceImpl implements ICommentService {
	
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
