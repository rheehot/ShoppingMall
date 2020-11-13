package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsDAO;
import com.dto.CartDTO;
import com.dto.GoodsDTO;

@Service
public class GoodsService {
	
	@Autowired
	GoodsDAO dao; 
	public List<GoodsDTO> goodsList(String gCategory){
		List<GoodsDTO> list = dao.goodsList(gCategory);
		return list;
	}
	public GoodsDTO goodsRetrieve(String gCode) {
		GoodsDTO dto = dao.goodsRetrieve(gCode);
		return dto;
	}
	public void cartAdd(CartDTO dto) {
		dao.cartAdd(dto);
		
	}
}
