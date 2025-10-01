package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.DTO.BoardDTO;
import com.kedu.study.services.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	
	@GetMapping
	public ResponseEntity<List<BoardDTO>> getList(){
		
		System.out.println("getList()까지 왔어용");
		
		List<BoardDTO> list = boardService.getList();
		return ResponseEntity.ok(list);
	}
}
