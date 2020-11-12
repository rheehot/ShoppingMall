package com.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.MemberDTO;

@Repository	// component-scan���� �ڵ� �� ����
public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate template; // �ڵ� ����
	
	public void memberAdd(MemberDTO m) {
		int n = template.insert("MemberMapper.memberAdd",m);
		System.out.println("MemberDAO��  memberAdd() insert Ŀ�� �Ϸ�"+n);
	}

	public MemberDTO login(Map<String, String> map) {
		MemberDTO dto = template.selectOne("MemberMapper.login", map);
		return dto;
	}

	public MemberDTO myPage(String userid) {
		MemberDTO dto = template.selectOne("MemberMapper.mypage",userid);
		return dto;
	}

}
/*
 * DAO��ü���� sqlsession�� �ڵ� ���Թ޾� DB�� ������
 */
 