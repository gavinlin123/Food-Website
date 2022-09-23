package com.example.FoodWebsite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.FoodWebsite.model.Item;
import com.example.FoodWebsite.model.Member;

public interface MemberDao extends JpaRepository<Member, Long>{
	
	//根據id查
//	@Query(name = "findAllById",nativeQuery = true,value = "select * from member where id=:id")
	Member findAllById(@Param("id")Long id);
	
	//登入功能
	@Query(name = "findMemberByUser_NameAndPassword",nativeQuery = true,value = "select * from member where user_name=:username AND password=:password")
	Member findMemberByUser_NameAndPassword(@Param("username")String username,@Param("password")String password);
	
	//根據名字查詢店家
	@Query(name = "findShopByShop_Name",nativeQuery = true,value = "select * from item where search=:search")
	List<Item> findMemberByUser_Name(@Param("search") String search);
}
