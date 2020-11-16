package com.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.CartDTO;
import com.dto.GoodsDTO;

@Repository
public class GoodsDAO {

	@Autowired
	SqlSessionTemplate template;
	
	public List<GoodsDTO> goodsList(String gCategory) {
		List<GoodsDTO> list = template.selectList("GoodsMapper.goodsList",gCategory);
		return list;
	}

	public GoodsDTO goodsRetrieve(String gCode) {
		GoodsDTO dto = template.selectOne("GoodsMapper.goodsRetrieve", gCode);
		return dto;
	}

	public void cartAdd(CartDTO dto) {
		int n = template.insert("CartMapper.cartAdd",dto);
		System.out.println("GoodsDAO : cartAdd() : insert�� ="+n);
	}

	public List<CartDTO> cartList(String userid) {
		List<CartDTO> list = template.selectList("CartMapper.cartList", userid);
		return list;
	}

	

	public void cartUpdate(HashMap<String, String> map) {
		template.update("CartMapper.cartUpdate",map);
	}

	public CartDTO cartByNum(int num) {
		CartDTO dto = template.selectOne("CartMapper.cartByNum", num);
		return dto;
	}

	public void cartDelete(int num) {
		template.delete("CartMapper.cartDelete",num);
		
	}

}
