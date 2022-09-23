package com.example.FoodWebsite.Service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoodWebsite.Dto.MemberDto;
import com.example.FoodWebsite.dao.MemberDao;
import com.example.FoodWebsite.model.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;

	/*
	 * * 根據id查詢
	 */
	
	@Override
	public Member findAllById(Long id) {
		return memberDao.findAllById(id);
	}
	
	/*
	 * 查詢username和password進行登入
	 * 登入成功後儲存session 的 login, id, shop_name
	 */
	@Override
	public String findMemberByUser_NameAndPassword(HttpSession session,String username,String password) {
		
		if(memberDao.findMemberByUser_NameAndPassword(username, password) == null) {
			session.setAttribute("login", false);
			return "帳號或密碼錯誤";
		}else {
			session.setAttribute("login", true);
			session.setAttribute("id", memberDao.findMemberByUser_NameAndPassword(username, password).getId());
			session.setAttribute("shop_name", memberDao.findMemberByUser_NameAndPassword(username, password).getShopName());
			return "登入成功";
		}	
		
	}

	/*
	 * 新增帳號
	 */
	@Override
	public Member save(MemberDto memberDto) {
		
		Member member = new Member();
		member.setUserName(memberDto.getUserName());
		member.setPassword(memberDto.getPassword());
		member.setEmail(memberDto.getEmail());
		member.setShopName(memberDto.getShopName());
		member.setTel(memberDto.getTel());
		member.setAddr(memberDto.getAddr());
		
		return memberDao.save(member);
	}

	/*
	 * 將session取得的id set進member後修改
	 */
	@Override
	public Member update(HttpSession session, MemberDto memberDto) {
		
		Member member = new Member();
		member.setId((Long)session.getAttribute("id"));
		member.setUserName(memberDto.getUserName());
		member.setPassword(memberDto.getPassword());
		member.setEmail(memberDto.getEmail());
		member.setShopName(memberDto.getShopName());
		member.setTel(memberDto.getTel());
		member.setAddr(memberDto.getAddr());
		
		return memberDao.save(member);
	}
	
	/*
	 * 根據session取得的id刪除
	 */
	@Override
	public void deleteMemberById(HttpSession session) {

		memberDao.deleteById((Long)session.getAttribute("id"));
	}



}
