package fun.peri.service;

import fun.peri.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICommentService {
    public void addcomment(Comment comment);

    public void deletecomment(Comment commetn);

    public Comment getcomment(int id);

    public void updatecomment(Comment comment);

    public List<Object> show(int spaceId);
}
