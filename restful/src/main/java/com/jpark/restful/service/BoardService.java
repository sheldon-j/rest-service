package com.jpark.restful.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpark.restful.dao.BoardDAO;
import com.jpark.restful.dto.BoardDTO;
import com.jpark.restful.util.Paging;

/**
 * @author ju.park
 *
 */
@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDao;
	
	public Map getBoardList(String page) {
		Map result = null;
		Paging paging = null;
		List resultList = null;
		int pageNum = 1;
		
		try{
			pageNum = Integer.parseInt(page);
		}catch(NumberFormatException e){
			pageNum = 1;
		}
		
		try{
			result = new HashMap();
			paging = new Paging(boardDao.getTotalSize(), pageNum);
			resultList = boardDao.getBoardList(paging);
			
			result.put("list", resultList);
			result.put("page", pageNum);
			result.put("pageInfo", paging);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Map getBoardOne(String idx){
		Map resultMap = null;
		int result = 0;
		String msg = "";
		
		try{
			resultMap = new HashMap();
			
			if(!idx.equals("")){
				resultMap.put("data", boardDao.getBoardInfoByID(idx));
				result = 200;
			}else{
				result = 600;
			}
		}catch(Exception e){
			result = 500;
			msg = e.getMessage();
		}
		
		resultMap.put("result", result);
		resultMap.put("msg", msg);
		
		return resultMap;
	}
	
	public Map addBoard(String member_id, String title, String contents, String board_type){
		Map returnMap = null;
		int result = 0;
		String msg = "";
		BoardDTO param = null;
		
		try{
			param = new BoardDTO();
			param.setMember_id(Integer.parseInt(member_id)); 
			param.setTitle(title);
			param.setContents(contents);
			param.setBoard_type(board_type);
			
			
			if(boardDao.addBoard(param) > 0){
				result = 200;
				msg = "Done.";
			}else{
				result = 400;
				msg = "Fail";
			}
		}catch(Exception e){
			result = 500;
			msg = e.getMessage();
			e.printStackTrace();
		}
		
		returnMap = new HashMap();
		returnMap.put("result", result);
		returnMap.put("msg", msg);
		
		return returnMap;
	}
	
	public Map updateBoard(String idx, String member_id, String title, String contents, String board_type){
		Map returnMap = null;
		int result = 0;
		String msg = "";
		BoardDTO param = null;
		
		try{
			param = new BoardDTO();
			param.setIdx(Integer.parseInt(idx)); 
			param.setMember_id(Integer.parseInt(member_id)); 
			param.setTitle(title);
			param.setContents(contents);
			param.setBoard_type(board_type);
			
			
			if(boardDao.updateBoard(param) > 0){
				result = 200;
				msg = "Done.";
			}else{
				result = 400;
				msg = "Fail";
			}
		}catch(Exception e){
			result = 500;
			msg = e.getMessage();
			e.printStackTrace();
		}
		
		returnMap = new HashMap();
		returnMap.put("result", result);
		returnMap.put("msg", msg);
		
		return returnMap;
	}
	
	public Map deleteBoard(String idx, String member_id){
		Map returnMap = null;
		int result = 0;
		String msg = "";
		BoardDTO param = null;
		
		try{
			param = new BoardDTO();
			param.setIdx(Integer.parseInt(idx)); 
			param.setMember_id(Integer.parseInt(member_id)); 
			
			if(boardDao.deleteBoard(param) > 0){
				result = 200;
				msg = "Done.";
			}else{
				result = 400;
				msg = "Fail";
			}
		}catch(Exception e){
			result = 500;
			msg = e.getMessage();
			e.printStackTrace();
		}
		
		returnMap = new HashMap();
		returnMap.put("result", result);
		returnMap.put("msg", msg);
		
		return returnMap;
	}
	
}