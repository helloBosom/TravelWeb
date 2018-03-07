package com.cissst.software.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cissst.software.model.Comment;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

@Service
public interface ICommentService {
	public void addcomment(Comment comment);
	public void deletecomment(Comment commetn);
	public Comment getcomment(int id);
	public void updatecomment(Comment comment);
	public List<Object> show(int spaceId);
}
