package fun.peri.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 产品实体类
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "tbl_product")
public class Product {
	// 产品编号
	@Id
	@GenericGenerator(strategy = "assigned", name = "product_assigned")
	@GeneratedValue(generator = "product_assigned")
	private String productid;

	// 产品名称
	@Column(name = "productname")
	private String productName;

	// 单价
	@Column
	private double price;

	// 天数
	@Column
	private String days;

	// 旅游线路（多对一）
	@ManyToOne(fetch = FetchType.EAGER , cascade=CascadeType.ALL)
	@JoinColumn(name = "routeid")
	private ViewRoute route = new ViewRoute();
	
	@OneToMany(cascade=CascadeType.REMOVE,mappedBy="product")
	private Set<ProductDetail> productDetails ;

	
	public Set<ProductDetail> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(Set<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	// 状态
	@Column(name = "status")
	private String status;

	@Column(name = "remarks", length = 100)
	private String remarks;

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public ViewRoute getRoute() {
		return route;
	}

	public void setRoute(ViewRoute route) {
		this.route = route;
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

	public Product(String productid, String productName, String days, String status, String remarks) {
		super();
		this.productid = productid;
		this.productName = productName;
		this.days = days;
		this.status = status;
		this.remarks = remarks;
	}

	public Product() {

	}

	public Product(String productid, String productName, String days) {
		super();
		this.productid = productid;
		this.productName = productName;

		this.days = days;

	}

	public Product(String productid, String productName, double price, String days, String status, String remarks) {
		super();
		this.productid = productid;
		this.productName = productName;
		this.price = price;
		this.days = days;
		this.status = status;
		this.remarks = remarks;
	}

	public Product(String productid, String productName, double price, String days, ViewRoute route, String status,
			String remarks) {
		super();
		this.productid = productid;
		this.productName = productName;
		this.price = price;
		this.days = days;
		this.route = route;
		this.status = status;
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productName=" + productName + ", price=" + price + ", days="
				+ days + ", status=" + status + ", remarks=" + remarks + "]";
	}

}
