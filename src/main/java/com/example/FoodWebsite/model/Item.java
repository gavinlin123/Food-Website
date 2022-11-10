package com.example.FoodWebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ITEM", nullable = false,unique = false)
	private String item;
	
	@Column(name = "PIC", nullable = false,unique = false)
	private String pic;
	
	@Column(name = "DESCRIPTION", nullable = true,unique = false)
	private String description;

	@Column(name = "START_DISCOUNT_DATE", nullable = true,unique = false)
	private String startDiscountDate;
	
	@Column(name = "END_DISCOUNT_DATE", nullable = true,unique = false)
	private String endDiscountDate;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDiscountDate() {
		return startDiscountDate;
	}

	public void setStartDiscountDate(String startDiscountDate) {
		this.startDiscountDate = startDiscountDate;
	}

	public String getEndDiscountDate() {
		return endDiscountDate;
	}

	public void setEndDiscountDate(String endDiscountDate) {
		this.endDiscountDate = endDiscountDate;
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", item=" + item + ", pic=" + pic + ", description=" + description
				+ ", startDiscountDate=" + startDiscountDate + ", endDiscountDate=" + endDiscountDate + ", member="
				+ member + "]";
	}

}
