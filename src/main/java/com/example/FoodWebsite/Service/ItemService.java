package com.example.FoodWebsite.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.FoodWebsite.Dto.ItemDto;
import com.example.FoodWebsite.model.Item;


public interface ItemService {

	// 查詢全部
	List<ItemDto> findAll();
	
	// 根據SessionID查詢賣家的全部商品
	List<ItemDto> findItemByMemberID(HttpSession session);
	
	// 根據商品名稱查詢
	List<ItemDto> findItemBySearch(String search);
	
	// 新增
	Item save(HttpSession session, ItemDto itemDto);
	
	// 修改
	Item update(HttpSession session, ItemDto itemDto);
	
	// 刪除
	void delete(ItemDto itemDto);


}
