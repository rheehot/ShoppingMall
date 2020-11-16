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
		System.out.println("LoginController :login() :loginForm���� �Ѿ�� ID,PASSWORD : " + map);
		MemberDTO dto = service.login(map);
		if (dto != null) {
			session.setAttribute("login", dto);
			return "redirect:/goodsList?gCategory=top";//�ּҷ� �̵�
			//���������������� top�������ֱ� 
		} else {
			model.addAttribute("mesg", "ȸ�� ������ �����ϴ�. �ٽ� �õ����ּ���. ");
			return "loginForm";//jsp�� �̵�
		}
	}

	@RequestMapping(value = "/loginCheck/logout")
	public String logout(HttpSession session) {
		System.out.println("LoginController : logout() : �α׾ƿ�! session���� �� main.jsp�� �̵�");
		session.invalidate();
		return "redirect:../";	//.xml�� ������ main.jsp�� �̵�
//		/loginCheck/logout �� ���� ��θ� �Ѿ�� �ϱ� ������ ../ �� loginCheck�� ���� �ּҷ� �̵�
	}
}
