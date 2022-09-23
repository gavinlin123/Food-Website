package com.example.FoodWebsite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {
	
	@PostMapping("/checklogin")
	public String checkLogin(HttpSession session) {
		String result = "false";
		if(session.getAttribute("login") == null) {
			session.setAttribute("login", false);
		}
		if ((boolean) session.getAttribute("login") == true) {
			result = "true";
		}

		return result;
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		String result = "false";

		session.setAttribute("login", false);
		
		if ((boolean) session.getAttribute("login") == false) {
			result = "true";
		}

		return result;
	}

}
