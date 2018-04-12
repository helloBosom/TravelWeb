package fun.peri.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_customer")

public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerid;
    @Column
    private String customername;
    @Column
    private String customernickname;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String iphone;
    @Column
    private String address;
    @Column
    private String gender;
    @Column
    private String remarks;

    public CustomerEntity() {

    }

    public CustomerEntity(String customername, String customernickname, String password, String email, String iphone,
                          String address, String gender, String remarks) {
        this.customername = customername;
        this.customernickname = customernickname;
        this.password = password;
        this.email = email;
        this.iphone = iphone;
        this.address = address;
        this.gender = gender;
        this.remarks = remarks;
    }

    public CustomerEntity(Integer customerid, String customername, String customernickname, String password,
                          String email, String iphone, String address, String gender, String remarks) {
        this.customerid = customerid;
        this.customername = customername;
        this.customernickname = customernickname;
        this.password = password;
        this.email = email;
        this.iphone = iphone;
        this.address = address;
        this.gender = gender;
        this.remarks = remarks;
    }


    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomernickname() {
        return customernickname;
    }

    public void setCustomernickname(String customernickname) {
        this.customernickname = customernickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
