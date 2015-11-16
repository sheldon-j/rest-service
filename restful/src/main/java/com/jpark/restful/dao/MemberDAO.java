package com.jpark.restful.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpark.restful.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private MemberDTO memberDto;
	
	public MemberDTO getInfoByID(String member_id){
		MemberDTO result = null;
		
		try{
			result = (MemberDTO) sqlSession.selectOne("getMemberInfoByID", member_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int getExistCountByID(String member_id){
		int result = 0;
		
		try{
			result = sqlSession.selectOne("getExistCountByID", member_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int putAccountInfo(String member_id, String member_pw, String member_name){
		int result = 0;
		HashMap param = null;
		
		try{
			param = new HashMap();
			param.put("member_id", member_id);
			param.put("member_pw", member_pw);
			param.put("member_name", member_name);
			
			result = sqlSession.insert("insertAccount", param);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
}
