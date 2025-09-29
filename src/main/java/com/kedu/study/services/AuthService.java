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
}
