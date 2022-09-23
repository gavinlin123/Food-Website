package com.example.FoodWebsite.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "USER_NAME", nullable = true,unique = true)
	private String userName;
	
	@Column(name = "PASSWORD", nullable = true,unique = false)
	private String password;
	
	@Column(name = "EMAIL", nullable = true,unique = true)
	private String email;
	
	@Column(name = "SHOP_NAME", nullable = true,unique = false)
	private String shopName;
	
	@Column(name = "TEL", nullable = true,unique = false)
	private String tel;
	
	@Column(name = "ADDR", nullable = true,unique = false)
	private String addr;
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Item> items;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

	
	@Override
	public String toString() {
		return "Member [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", shopName=" + shopName + ", tel=" + tel + ", addr=" + addr + "]";
	}
	
	
	
}
