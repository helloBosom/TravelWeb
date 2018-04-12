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

import org.hibernate.annotations.GenericGenerator;

/**
 * 订单实体类
 * @author Administrator
 *
 */
@Entity
@Table(name = "tbl_order")
public class Order {
	//订单编号
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	//订单号
	@Column(name = "ordernum", length = 20)
	private String orderNum;
	
	//订单人
	@Column(name = "customer", length = 20)
	private String customer;
	
	//联系电话1
	@Column(name = "c_phone1", length = 11)
	private String c_phone1;
	
	//联系电话2
	@Column(name = "c_phone2", length = 11)
	private String c_phone2;
	
	//产品名称（多对一）
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "productid")
	private Product product;
	
	
	// 旅游线路（多对一）
/*	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "routeid")
	private ViewRoute viewroute;
	*/
	//下单日期
	@Column(name = "submitdate")
	private Date submitDate;
	
	//出团日期起
	@Column(name = "startdate")
	private String startDate;
	
	//出团日期止
	@Column(name = "enddate")
	private String endDate;
	
	//人数
	@Column(name = "peoplenum", length = 11)
	private Integer peopleNum;
	
	//应付总金额
	@Column(name = "payable")
	private Double payable;
	
	//未付总金额
	@Column(name = "unpay")
	private Double unPay;
	
	//订单状态
	@Column(name = "orderstatus", length = 1)
	private String orderStatus;
	
	//负责人名字
	@Column(name = "managename", length = 20)
	private String manageName;
	
	//负责人电话
	@Column(name = "managephone", length = 11)
	private String managePhone;
	
	//备注
	@Column(name = "remarks", length = 100)
	private String remarks;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getC_phone1() {
		return c_phone1;
	}

	public void setC_phone1(String c_phone1) {
		this.c_phone1 = c_phone1;
	}

	public String getC_phone2() {
		return c_phone2;
	}

	public void setC_phone2(String c_phone2) {
		this.c_phone2 = c_phone2;
	}

	public void setManagePhone(String managePhone) {
		this.managePhone = managePhone;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/*public ViewRoute getWiewroute() {
		return viewroute;
	}

	public void setWiewroute(ViewRoute viewroute) {
		this.viewroute = viewroute;
	}*/

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}

	
	public Double getUnPay() {
		return unPay;
	}

	public void setUnPay(Double unPay) {
		this.unPay = unPay;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getManageName() {
		return manageName;
	}

	public void setManageName(String manageName) {
		this.manageName = manageName;
	}

	

	public String getManagePhone() {
		return managePhone;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Order() {
	
	}

	public Double getPayable() {
		return payable;
	}

	public void setPayable(Double payable) {
		this.payable = payable;
	}

	public Order(Integer orderId, String orderNum, String customer, String c_phone1) {
		super();
		this.orderId = orderId;
		this.orderNum = orderNum;
		this.customer = customer;
		this.c_phone1 = c_phone1;
	}
	
	

}
