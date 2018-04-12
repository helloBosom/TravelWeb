package fun.peri.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_view_space")
public class ViewSpace {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "space_id")
	protected int spaceId;

	@Column(name = "space_name")
	protected String spaceName;

	protected String description;
	protected String website;
	protected String address;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name="theme_id")
	protected Theme theme=new Theme();

	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name="cityid")
	protected City city;
	
	public Theme getTheme() {
		return theme;
	}

	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@Column(name = "price")
	protected double price;

	@Column(name = "status")
	protected String status;
	
	@Column (name="remarks")
	protected String remarks;

	@Column(name="view_picture")
	protected String picture;

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@OneToMany(mappedBy = "viewSpace", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	protected List<ViewPoint> viewPoints;

	@OneToMany(mappedBy = "viewSpace", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	protected Set<Comment> comments;
	
	

	public Set<Comment> getComments() {
		return comments;
	}


	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}


	public int getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

	public String getSpaceName() {
		return spaceName;
	}

	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	public String getDescription() {
		return description;
	}

	public String getBriefDesc(){
		if (description == null) {
			return "";
		}else{
			int len = description.length()>100?100:description.length();
			return description.substring(0,len);
		}
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<ViewPoint> getViewPoints() {
		return viewPoints;
	}

	public void setViewPoints(List<ViewPoint> viewPoints) {
		this.viewPoints = viewPoints;
	}
}