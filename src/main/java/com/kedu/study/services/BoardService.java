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


	public BoardDTO getPost(int seq){

		BoardDTO boardDTO = boardDAO.getPost(seq);

		return boardDTO;
	}
	public int writePost(BoardDTO boardDTO)
	{
		return boardDAO.writePost(boardDTO);
	}
	
	public void deletePost(int seq) {
		boardDAO.deletePost(seq);
	}
	
	public void modifyPost(int seq, BoardDTO boardDTO) {
		boardDTO.setSeq(seq);
		boardDAO.modifyPost(boardDTO);
	}
	
}
