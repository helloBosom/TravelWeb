package fun.peri.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import fun.peri.model.Comment;

@Repository
public class CommentDao extends BaseDao<Comment> {
	public List<Object> show(int spaceId){
		String hql="select c.content from Comment c inner join c.viewSpace v where "
				+ "c.status=1 and v.spaceId="+spaceId;
		
		return find(hql);
		
	}
}
