package com.jpark.restful.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpark.restful.dao.MemberDAO;
import com.jpark.restful.dto.MemberDTO;
import com.jpark.restful.util.HSecurity;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDao;
	
	public Map getLogin(String member_id, String member_pw){
		Map result = null;
		boolean flag = false;
		
		try{
			result = new HashMap();
			MemberDTO member = memberDao.getInfoByID(member_id);
			if(member != null){
				if(member.getMember_pw().equals(HSecurity.getInstance().encryptSimplex(member_pw, 50))){
					flag = true;
				}
			}
			
			result.put("result", flag);
			result.put("member", member);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean isExistID(String member_id){
		boolean result = false;
		
		try{
			if(memberDao.getExistCountByID(member_id) > 0){
				result = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Map createAccount(String member_id, String member_pw, String member_name){
		Map result = null;
		
		try{
			result = new HashMap();
			if(isExistID(member_id)){
				result.put("result", false);
				result.put("msg", "Already exist ID.");
			}else{
				result.put("result", memberDao.putAccountInfo(member_id, HSecurity.getInstance().encryptSimplex(member_pw, 50), member_name) > 0 ? true : false);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
}
