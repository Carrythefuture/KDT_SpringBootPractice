package com.kedu.study.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.DTO.BoardDTO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession myBatis;
	
	public List<BoardDTO> getList(){
		
		return myBatis.selectList("Board.getList");
	}
	
	public int writePost(BoardDTO boardDTO)
	{
		myBatis.insert("Board.writePost",boardDTO);
		
		System.out.println(boardDTO.getSeq());
		return boardDTO.getSeq();
	}
	
	public BoardDTO getPost(int seq){


		return myBatis.selectOne("Board.getPost",seq);
	}
	public void deletePost(int seq) {
		myBatis.delete("Board.deletePost",seq);
	}
	
	public void modifyPost(BoardDTO boardDTO) {
		myBatis.update("Board.modifyPost",boardDTO);
	}
}
