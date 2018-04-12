package fun.peri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Configurable;

@Entity
@Table(name="tbl_comment")
public class Comment {

	public Comment() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="commentId")
	protected int commentId;
	
	@Column(name="userIp")
	protected String ip;
	
	@Column(name="content")
	protected String content;
	
	@Column(name="status")
	protected int status;
	
	@Column(name="remark")
	protected String remark;
	
	@Column(name="username")
	protected String username;
	
	@Column(name="usertel")
	protected String phone;
	

	@ManyToOne
	@JoinColumn(name="space_id")
	protected ViewSpace viewSpace;
	
	public ViewSpace getViewSpace() {
		return viewSpace;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public void setViewSpace(ViewSpace viewSpace) {
		this.viewSpace = viewSpace;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Comment(int commentId) {
		this.commentId = commentId;
	}


	
}
