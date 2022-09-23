package com.example.FoodWebsite.Service;

import javax.servlet.http.HttpSession;

import com.example.FoodWebsite.Dto.ItemDto;

public interface PicFolderService {
	
	//新增圖片
	String savePic(HttpSession session,ItemDto itemDto);
	
	//修改圖片
	String updatePic(HttpSession session, ItemDto itemDto);
	
	//刪除圖片
	String deletePic(ItemDto itemDto);

}
