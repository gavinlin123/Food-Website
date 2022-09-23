package com.example.FoodWebsite.Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoodWebsite.Dto.ItemDto;
import com.example.FoodWebsite.dao.ItemDao;
import com.example.FoodWebsite.model.Item;
import com.example.FoodWebsite.model.Member;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemDao itemDao;

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PicFolderService picFolderService;

	/* 
	 * 查詢全部
	 */
	@Override
	public List<ItemDto> findAll() {
		
		List<ItemDto> itemDtos = null;
		List<Item> items =  itemDao.findAll();
		
		if (items != null && items.size() > 0){
			itemDtos = new ArrayList<>();
			for (Item item : items) {
				ItemDto itemDto = new ItemDto();
				BeanUtils.copyProperties(item, itemDto);
				itemDtos.add(itemDto);
			}
		}
		return itemDtos;
	}
	
	/* 
	 * 根據SessionID查詢賣家的全部商品
	 */
	@Override
	public List<ItemDto> findItemByMemberID(HttpSession session) {
		
		List<ItemDto> itemDtos = null;
		List<Item> items = itemDao.findItemByMemberId((Long)session.getAttribute("id"));
		
		if (items != null && items.size() > 0) {
			itemDtos = new ArrayList<>();
			for (Item item : items) {
				ItemDto itemDto = new ItemDto();
				BeanUtils.copyProperties(item, itemDto);
				itemDtos.add(itemDto);
			}
		}
		return itemDtos;
	}
	
	/* 
	 * 根據Search查詢商品名稱的商品
	 */
	@Override
	public List<ItemDto> findItemBySearch(String search) {
		
		List<ItemDto> itemDtos = null;
		List<Item> items = itemDao.findItemBySearch(search);
		
		if (items != null && items.size() > 0) {
			itemDtos = new ArrayList<>();
			for (Item item : items) {
				ItemDto itemDto = new ItemDto();
				BeanUtils.copyProperties(item, itemDto);
				itemDtos.add(itemDto);
			}
		}
		return itemDtos;
	}
	
	/* 
	 * 新增商品
	 */
	@Override
	
	public Item save(HttpSession session, ItemDto itemDto) {
		
		String picPath = picFolderService.savePic(session,itemDto);
		Item item = new Item();
		Member member = memberService.findAllById((Long)session.getAttribute("id"));
		item.setItem(itemDto.getItem());
		item.setPic(picPath);
		item.setDescription(itemDto.getDescription());
		item.setStartDiscountDate(itemDto.getStartDiscountDate());
		item.setEndDiscountDate(itemDto.getEndDiscountDate());
		item.setMember(member);

		return itemDao.save(item);
	}

	/* 
	 * 修改商品
	 */
	@Override
	public Item update(HttpSession session, ItemDto itemDto) {
		
		String picPath = picFolderService.updatePic(session,itemDto);
		Item item = new Item();
		Member member = memberService.findAllById((Long)session.getAttribute("id"));
		item.setId(Long.parseLong(itemDto.getId()));
		item.setItem(itemDto.getItem());
		item.setPic(picPath);
		item.setDescription(itemDto.getDescription());
		item.setStartDiscountDate(itemDto.getStartDiscountDate());
		item.setEndDiscountDate(itemDto.getEndDiscountDate());
		item.setMember(member);
		
		return itemDao.save(item);
	}
	
	/* 
	 * 根據商品編號刪除商品
	 */
	@Override
	public void delete(ItemDto itemDto) {
		
		picFolderService.deletePic(itemDto);
		Item item = new Item();
		item.setId(Long.parseLong(itemDto.getId()));
		itemDao.deleteById(item.getId());
		
	}

}
