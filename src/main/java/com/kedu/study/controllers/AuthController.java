package com.kedu.study.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

		//우리는 dto로 받아서 null이 아니면 성공임.
		Map<String,String> map = new HashMap<>();

		if(result!=null) {
			System.out.println("result :" + result.getId());
			session.setAttribute("loginId", dto.getId());

			map.put("loginId", dto.getId());
			return ResponseEntity.ok(map);
		}
//		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}

	@PostMapping("/logout")
	public ResponseEntity<Map<String,String>> logout(HttpSession session){
		System.out.println("여기는 로그아웃이얌");
		System.out.println("세션" + (String)session.getAttribute("loginId"));
	    // 세션 초기화
	    session.invalidate(); // 로그인 관련 모든 세션 정보 제거

	    // 클라이언트에게 명시적 응답
	    Map<String, String> map = new HashMap<>();
	    map.put("status", "success");
	    map.put("message", "로그아웃 완료");

	    return ResponseEntity.ok(map);
	}

	@PostMapping("/insert")
	public ResponseEntity<Void> insert (@RequestBody AuthDTO dto) {
		System.out.println(dto.getId() + ":" + dto.getPw() + ":" + dto.getName());
		authService.insert(dto);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable String id, HttpSession session){
		authService.delete(id);
		session.invalidate(); // 로그인 관련 모든 세션 정보 제거
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<Void> test (HttpSession session){
		System.out.println("세션" + (String)session.getAttribute("loginId"));

		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/myPage/{id}")
	public ResponseEntity<AuthDTO> myPage (@PathVariable String id){
		AuthDTO dto = authService.myPage(id);
		return ResponseEntity.ok(dto);
	}
}
