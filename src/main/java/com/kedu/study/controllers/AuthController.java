package com.kedu.study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.DTO.AuthDTO;
import com.kedu.study.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<String> insert(@RequestBody AuthDTO dto){
		System.out.println(dto.getId() + ":" + dto.getPw());
		AuthDTO result = authService.login(dto);
		
		String text = "";
		if(result!=null) {
			text = "success";
		}
		else
		{
			text = "fail";
		}
		return ResponseEntity.ok(text);
	}
}
