package com.example.FoodWebsite.Dto;

import org.springframework.web.multipart.MultipartFile;

public class ItemDto {
	
	private String id;
	private String item;
	private MultipartFile pic;
	private String description;
	private String startDiscountDate;
	private String endDiscountDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public MultipartFile getPic() {
		return pic;
	}
	public void setPic(MultipartFile pic) {
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
}
