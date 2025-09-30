package com.kedu.study.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.DTO.AuthDTO;
import com.kedu.study.services.AuthService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String,String>> login(@RequestBody AuthDTO dto, HttpSession session){
		System.out.println(dto.getId() + ":" + dto.getPw());
		
		AuthDTO result = authService.login(dto);
		
		String text = "";
		
		//우리는 dto로 받아서 null이 아니면 성공임.
		Map<String,String> map = new HashMap<>();
		if(result!=null) {
			text = "success";
			session.setAttribute("loginId", dto.getId());
			
			
			map.put("loginId", dto.getId());
		}
		else
		{
			text = "fail";
		}
		
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Void> insert (@RequestBody AuthDTO dto) {
		System.out.println(dto.getId() + ":" + dto.getPw() + ":" + dto.getName());
		authService.insert(dto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<Void> test (HttpSession session){
		System.out.println("세션" + (String)session.getAttribute("loginId"));
		
		return ResponseEntity.ok().build();
	}
}
