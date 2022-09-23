package com.example.FoodWebsite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoodWebsite.Dto.ItemDto;
import com.example.FoodWebsite.Service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@PostMapping("/findall")
	public List<ItemDto> findAll(){
		return itemService.findAll();
	}
	
	@PostMapping("/findmemberitem")
	public List<ItemDto> findItemByID(HttpSession session){
		return itemService.findItemByMemberID(session);
	}
	
	@PostMapping("/search")
	public List<ItemDto> findItemBySearch(String search){
		return itemService.findItemBySearch(search);
	}
	
	@PostMapping("/save")
	public String saveItem(HttpSession session, ItemDto itemDto){
		itemService.save(session,itemDto);
		return "成功新增商品";
	}
	
	@PostMapping("/update")
	public String updateItem(HttpSession session, ItemDto itemDto){
		itemService.update(session, itemDto);
		return "成功更新商品";
	}
	
	@PostMapping("/delete")
	public String deleteItem(ItemDto itemDto){
		itemService.delete(itemDto);
		return "成功刪除商品";
	}
}
