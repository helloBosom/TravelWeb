package fun.peri.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_travel_tailer")
public class TravelTailer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer travelid;
	@Column
	private String name;
	@Column
	private String telephone;
	@Column
	private String startcity;
	@Column
	private Date startdate;
	@Column
	private int days;
	@Column
	private int peoplenumber;
	@Column
	private Double avgexpense;
	@Column
	private String cityname;
	@Column
	private char status;
	@Column
	private String remarks;
	public Integer getTravelid() {
		return travelid;
	}
	public void setTravelid(Integer travelid) {
		this.travelid = travelid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getStartcity() {
		return startcity;
	}
	public void setStartcity(String startcity) {
		this.startcity = startcity;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getPeoplenumber() {
		return peoplenumber;
	}
	public void setPeoplenumber(int peoplenumber) {
		this.peoplenumber = peoplenumber;
	}
	public Double getAvgexpense() {
		return avgexpense;
	}
	public void setAvgexpense(Double avgexpense) {
		this.avgexpense = avgexpense;
	}
	
	
	
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public TravelTailer() {
		
	}
	
	public TravelTailer(Integer travelid, String name, String telephone, String startcity, Date startdate, int days,
			int peoplenumber, Double avgexpense, String cityname, char status, String remarks) {
		super();
		this.travelid = travelid;
		this.name = name;
		this.telephone = telephone;
		this.startcity = startcity;
		this.startdate = startdate;
		this.days = days;
		this.peoplenumber = peoplenumber;
		this.avgexpense = avgexpense;
		this.cityname = cityname;
		this.status = status;
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "TravelTailer [travelid=" + travelid + ", name=" + name + ", telephone=" + telephone + ", startcity="
				+ startcity + ", startdate=" + startdate + ", days=" + days + ", peoplenumber=" + peoplenumber
				+ ", avgexpense=" + avgexpense + ", cityname=" + cityname + ", status=" + status + ", remarks="
				+ remarks + "]";
	}
	
	
	
}
