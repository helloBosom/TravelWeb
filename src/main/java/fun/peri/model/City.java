package fun.peri.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_city")
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	protected int id;
	
	@Column(name="cityname")
	protected String cityname;
	
	@Column(name="remarks")
	protected String remarks;

	public synchronized int getId() {
		return id;
	}

	public synchronized void setId(int id) {
		this.id = id;
	}

	public synchronized String getCityname() {
		return cityname;
	}

	public synchronized void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public synchronized String getRemarks() {
		return remarks;
	}

	public synchronized void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public City(int id, String cityname, String remarks) {
		super();
		this.id = id;
		this.cityname = cityname;
		this.remarks = remarks;
	}

	public City() {
		
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", cityname=" + cityname + ", remarks=" + remarks + "]";
	}
	
	
	
	

	
	
	
}
