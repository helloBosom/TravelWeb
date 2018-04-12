package fun.peri.model;

import java.util.Date;

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
@Table(name="tbl_route")
public class ViewRoute {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer routeid;
	@Column
	private String routename;
	@Column
	private String routestates;
	@Column
	private String routedescribe;
	@Column
	private String routeuserid;
	@Column
	private Date  publishdate;
	@Column
	private Date enddate;
	@Column(name="status")
	private char status;
	@Column
	private String remarks;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tourismthemeid")
	private Theme viewTheme;
	
	
	
	public ViewRoute() {
		
	}
	
	public Integer getRouteid() {
		return routeid;
	}
	public void setRouteid(Integer routeid) {
		this.routeid = routeid;
	}
	public String getRoutename() {
		return routename;
	}
	public void setRoutename(String routename) {
		this.routename = routename;
	}
	public String getRoutestates() {
		return routestates;
	}
	public void setRoutestates(String routestates) {
		this.routestates = routestates;
	}
	public String getRoutedescribe() {
		return routedescribe;
	}
	public void setRoutedescribe(String routedescribe) {
		this.routedescribe = routedescribe;
	}
	public String getRouteuserid() {
		return routeuserid;
	}
	public void setRouteuserid(String routeuserid) {
		this.routeuserid = routeuserid;
	}
	public Date getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	
	public ViewRoute(Integer routeid, String routename, String routestates, String routedescribe, String routeuserid,
			Date publishdate, Date enddate, String hotdegree, char status, double price, String remarks,
			Theme viewTheme) {
		super();
		this.routeid = routeid;
		this.routename = routename;
		this.routestates = routestates;
		this.routedescribe = routedescribe;
		this.routeuserid = routeuserid;
		this.publishdate = publishdate;
		this.enddate = enddate;
		this.status = status;
		this.remarks = remarks;
		this.viewTheme = viewTheme;
	}

	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Theme getViewTheme() {
		return viewTheme;
	}
	public void setViewTheme(Theme viewTheme) {
		this.viewTheme = viewTheme;
	}
	public ViewRoute(Integer routeid, String routename, String routestates, String routedescribe, String routeuserid,
			Date publishdate, Date enddate, String hotdegree, char status, String remarks) {
		
		this.routeid = routeid;
		this.routename = routename;
		this.routestates = routestates;
		this.routedescribe = routedescribe;
		this.routeuserid = routeuserid;
		this.publishdate = publishdate;
		this.enddate = enddate;
		this.status = status;
		this.remarks = remarks;
	}
	

}
