package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class LoginController {

	@Autowired
	MemberService service;

	@RequestMapping("/login")
	public String login(@RequestParam HashMap<String, String> map, HttpSession session, Model model) {
		System.out.println("loginForm���� �Ѿ�� ID,PASSWORD : " + map);
		MemberDTO dto = service.login(map);
		if (dto != null) {
			session.setAttribute("login", dto);
			return "main";
		} else {
			model.addAttribute("mesg", "ȸ�� ������ �����ϴ�. �ٽ� �õ����ּ���. ");
			return "loginForm";
		}
	}
}
