package com.example.FoodWebsite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoodWebsite.Dto.MemberDto;
import com.example.FoodWebsite.Service.MemberService;
import com.example.FoodWebsite.model.Member;


@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;


	@PostMapping("/signup")
	public String signup(@RequestBody MemberDto memberDto) {
		
		memberService.save(memberDto);
		
		return "註冊成功";
		
	}
	
	@PostMapping("/login")
	public String login(HttpSession session,String username,String password) {
		
		return memberService.findMemberByUser_NameAndPassword(session, username, password);
		
		
	}
	
	@PostMapping("/update")
	public Member update(HttpSession session, @RequestBody MemberDto memberDto) {
		
		return memberService.update(session, memberDto);
		
	}
	
	@PostMapping("/delete")
	public void deleteMem(HttpSession session) {

		memberService.deleteMemberById(session);
		
	}

}
