package com.jpark.restful.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpark.restful.dto.BoardDTO;
import com.jpark.restful.util.Paging;


@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private BoardDTO boardDto;
	
	public int getTotalSize(){
		return sqlSession.selectOne("getTotalSize");
	}
	
	public List getBoardList(Paging paging){
		List result = null;
		
		try{
			result = (List)sqlSession.selectList("getBoardList", paging);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public BoardDTO getBoardInfoByID(String idx){
		BoardDTO result = null;
		
		try{
			result = (BoardDTO) sqlSession.selectOne("getBoardInfoByID", idx);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int addBoard(BoardDTO boardDto){
		int result = 0;
		
		try{
			result = sqlSession.insert("addBoard", boardDto);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int updateBoard(BoardDTO boardDto){
		int result = 0;
		
		try{
			result = sqlSession.update("updateBoard", boardDto);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int deleteBoard(BoardDTO boardDto){
		int result = 0;
		
		try{
			result = sqlSession.update("deleteBoard", boardDto);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
}
