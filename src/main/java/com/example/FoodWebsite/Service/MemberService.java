package com.example.FoodWebsite.Service;

import javax.servlet.http.HttpSession;

import com.example.FoodWebsite.Dto.MemberDto;
import com.example.FoodWebsite.model.Member;

public interface MemberService {
	
	//根據id查詢單個
	Member findAllById(Long id);

	// 登入
	String findMemberByUser_NameAndPassword(HttpSession session,String username,String password);

	// 新增
	Member save(MemberDto memberDto);
	
	// 修改
	Member update(HttpSession session, MemberDto memberDto);

	// 刪除
	void deleteMemberById(HttpSession session);


}
