package com.example.FoodWebsite;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.FoodWebsite.dao.MemberDao;
import com.example.FoodWebsite.model.Member;

@SpringBootTest
class FoodWebsiteApplicationTests {
	
	@Autowired
	MemberDao memberDao;

	@Test
	void contextLoads() {
		
		Member member = new Member();
		
		member.setUserName("gavinlin123");
		member.setPassword("1qaz2wsx");
		member.setEmail("gavinlin123@yahoo.com.tw");
		member.setShopName("gavinlin123");
		member.setTel("04-24820991");
		member.setAddr("台中市大里區新南路260號");
		
		memberDao.save(member);
		
		
		List<Member> members = memberDao.findAll();
		
		System.out.println(members.get(0));
	
		
	}

}
