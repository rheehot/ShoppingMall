package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	GoodsService service;
	
	@RequestMapping(value="/goodsList")
	public ModelAndView goodsList(@RequestParam("gCategory") String gCategory) {
//		if(gCategory == null) {
//			gCategory="top";
//		}
		List<GoodsDTO> list = service.goodsList(gCategory);
		ModelAndView mav = new ModelAndView();
		
		//request.setAttribute("goodsList",list)�� ���� 
		mav.addObject("goodsList",list);
		mav.setViewName("main");//main.jsp
		return mav;
	}
	
	@RequestMapping(value="/goodsRetrieve")//view�������� goodsRetrieve.jsp
	@ModelAttribute("goodsRetrieve")// request�� key��
	public GoodsDTO goodsRetrieve(@RequestParam("gCode") String gCode) {
		System.out.println("GoodsController : goodRetrieve() : goodsList���� �Ѿ�� gCode : "+gCode);
		GoodsDTO dto = service.goodsRetrieve(gCode);
		return dto;	//request.setAttribute("goodsRetrieve",dto);
	}
	
	@RequestMapping("/loginCheck/cartAdd")//interceptor�� ��ģ��.
	public String cartAdd(CartDTO dto,HttpSession session) {
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		dto.setUserid(login.getUserid());
		System.out.println("GoodsController : cartAdd() : cartDTO :" +dto);
		session.setAttribute("mesg",dto.getgCode());
		service.cartAdd(dto);
		return "redirect:../goodsRetrieve?gCode="+dto.getgCode();
	}
	
}
