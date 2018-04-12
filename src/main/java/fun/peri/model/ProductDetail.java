package fun.peri.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

	/**
	 * 产品详情信息
	 *
	 */
	@Entity
	@Table(name = "tbl_productdetail")
	public class ProductDetail {

	// 产品明细编号
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "productid" )
	private Product product = new Product();

	// 线路
	@Column(name = "date", length = 500)
	private String date;

	// 线路
	@Column(name = "route", length = 500)
	private String route;

	// 目的地
	@Column(name = "destination")
	private String destination;
	// 详情信息
	@Column(name = "detail")
	private String detail;
	// 备注信息
	@Column(name = "remarks", length = 100)
	private String remarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ProductDetail() {

	}

	public ProductDetail(Integer id, Product product, String date, String route, String destination, String detail,
			String remarks) {
		super();
		this.id = id;
		this.product = product;
		this.date = date;
		this.route = route;
		this.destination = destination;
		this.detail = detail;
		this.remarks = remarks;
	}

	public ProductDetail(Integer id, String date, String route, String destination, String detail, String remarks) {
		super();
		this.id = id;
		this.date = date;
		this.route = route;
		this.destination = destination;
		this.detail = detail;
		this.remarks = remarks;
	}

	
	
	
	public ProductDetail(Product product, String date, String route, String destination, String detail,
			String remarks) {
		super();
		this.product = product;
		this.date = date;
		this.route = route;
		this.destination = destination;
		this.detail = detail;
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", date=" + date + ", route=" + route + ", destination=" + destination
				+ ", detail=" + detail + ", remarks=" + remarks + "]";
	}

}