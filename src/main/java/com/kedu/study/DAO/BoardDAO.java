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
	
}
