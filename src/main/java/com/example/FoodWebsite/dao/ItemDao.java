package com.example.FoodWebsite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.FoodWebsite.model.Item;

public interface ItemDao extends JpaRepository<Item, Long>{
	
	//根據member_id查詢
	@Query(name = "findItemByMemberId",nativeQuery = true,value = "select * from item where member_id=:memberId")
	List<Item> findItemByMemberId(@Param("memberId") Long memberId);
	
	//根據名字查詢商品
	@Query(name = "findItemByName",nativeQuery = true,value = "select * from item where item=:search")
	List<Item> findItemBySearch(@Param("search") String search);

}
