package com.kedu.study.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.DAO.BoardDAO;
import com.kedu.study.DTO.BoardDTO;

@Service
public class BoardService {
	
	
	@Autowired
	BoardDAO boardDAO;
	
	public List<BoardDTO> getList(){
		
		List<BoardDTO> list = boardDAO.getList();
		
		return list;
	}
}
