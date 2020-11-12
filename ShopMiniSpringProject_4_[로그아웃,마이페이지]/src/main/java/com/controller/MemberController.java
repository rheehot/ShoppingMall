package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService service;	// MemberService ��ü �ڵ� ����
	
	@RequestMapping(value = "/memberAdd")	// memberForm.jsp ���� ������ ����
	public String memberAdd(MemberDTO m,Model model) {// form���� �Ѿ�� �����͸� MemberDTO�� �ڵ�����
		service.memberAdd(m);	// ȸ������ ����
		model.addAttribute("success","ȸ������ ����");	// success�� ���� ���� -> main.jsp���� ����
		return "main";	//main.jsp
	}
	
	@RequestMapping(value="/loginCheck/myPage")// loginCheck���� ������ ���� �α��� �˻縦 �ϵ���!
	// ���ͼ��Ϳ��� �α��� ���� �� ������ �̵�
	public String myPage(HttpSession session) {
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String userid = dto.getUserid();
		dto = service.myPage(userid);
		session.setAttribute("login", dto); 	//�ٽ� login�� dto�Ⱦ��ֱ�
		System.out.println(dto);
		return "redirect:../myPage";	//servlet-context�� ���
	}

}
