package com.kedu.study.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.DAO.AuthDAO;
import com.kedu.study.DTO.AuthDTO;

@Service
public class AuthService {

	@Autowired
	private AuthDAO authDAO;


	public AuthDTO login(AuthDTO dto) {

		return authDAO.login(dto);
	}
	public int insert(AuthDTO dto) {

		return authDAO.insert(dto);
	}

	public int delete(String id) {

		return authDAO.delete(id);
	}
	
	public AuthDTO myPage(String id) {

		return authDAO.myPage(id);
	}
	
	public AuthDTO update(AuthDTO dto) {

		return authDAO.update(dto);
	}
}
