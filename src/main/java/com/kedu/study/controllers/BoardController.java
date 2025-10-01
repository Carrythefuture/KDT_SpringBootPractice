package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping("/{seq}")
	public ResponseEntity<BoardDTO> getPost(@PathVariable int seq) {
	    BoardDTO dto = boardService.getPost(seq);
	    return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<Integer> writePost(@RequestBody BoardDTO boardDTO){
		System.out.println("writePost()까지 왔어용");
		
		int result = boardService.writePost(boardDTO);
		
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/{seq}")
	public ResponseEntity<Void> deletePost(@PathVariable int seq){
		System.out.println("deletePost()까지 왔어용");
		boardService.deletePost(seq);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{seq}")
	public ResponseEntity<Void> modifyPost(@PathVariable int seq, @RequestBody BoardDTO boardDTO){
		System.out.println("modifyPost()까지 왔어용");
		boardService.modifyPost(seq,boardDTO);
		return ResponseEntity.ok().build();
	}
	
}
