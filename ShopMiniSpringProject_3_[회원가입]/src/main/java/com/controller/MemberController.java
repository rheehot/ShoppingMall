package com.controller;

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

}
