package com.korea1.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/SecTest")
@Controller
public class SecurityTestController {

	@GetMapping("/all")
	public void doAll() {
		log.info("��� ����� ���ٰ���");
	}
	@GetMapping("/member")
	public void doMember() {
		log.info("�Ϲ� ����� ���ٰ���");
	}
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("�����ڸ� ���� ����");
	}
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("���� �ź� : " + auth);
		model.addAttribute("msg","Access Denied");
	}
	
	@GetMapping("/customLogin")
	public void Login(String error, String logout, Model model) {
		log.info("error : " + error);
		log.info("logout : " + logout);
		
		if(error !=null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		if(logout !=null) {
			model.addAttribute("logout", "Logout!!");
		}
	}
	
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("custom logout");
	}
	
}
