package com.cissst.software.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "t_view_point")
public class ViewPoint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "point_id")
	protected int pointId;

	@Column(name = "point_name")
	protected String pointName;

	@Column(name = "ticket_price")
	protected float ticketPrice;

	protected String description;
	
	@Column(name = "img_file")
	protected String imgFile;

	@ManyToOne
	@JoinColumn(name = "space_id")
	protected ViewSpace viewSpace = new ViewSpace();

	public int getPointId() {
		return pointId;
	}

	public void setPointId(int pointId) {
		this.pointId = pointId;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public float getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ViewSpace getViewSpace() {
		return viewSpace;
	}

	public void setViewSpace(ViewSpace viewSpace) {
		this.viewSpace = viewSpace;
	}

	public String getImgFile() {
		return imgFile;
	}

	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}

	@Override
	public String toString() {
		return "ViewPoint [pointId=" + pointId + ", pointName=" + pointName + ", ticketPrice=" + ticketPrice
				+ ", description=" + description + "]";
	}
	
	
}