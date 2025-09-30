package com.kedu.study.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.DTO.AuthDTO;

@Repository
public class AuthDAO {
	@Autowired
	private SqlSession myBatis;

	public AuthDTO login(AuthDTO dto) {

		return myBatis.selectOne("Auth.login", dto);
	}

	public int insert(AuthDTO dto) {

		return myBatis.insert("Auth.insert",dto);
	}

	public int delete(String id) {

		return myBatis.insert("Auth.delete",id);
	}

	public AuthDTO myPage(String id) {

		return myBatis.selectOne("Auth.myPage",id);
	}
}
