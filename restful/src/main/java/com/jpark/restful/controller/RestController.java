package com.jpark.restful.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpark.restful.service.BoardService;
import com.jpark.restful.service.MemberService;
import com.jpark.restful.util.JSONUtil;

@Controller
@RequestMapping(value="/rest")
public class RestController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET, produces={"application/json; charset=UTF8"})
	public @ResponseBody String me( @RequestParam String member_id, 
									@RequestParam String member_pw){	
		
		return JSONUtil.getInstance().toJSONString(memberService.getLogin(member_id, member_pw));
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST, produces={"application/json; charset=UTF8"})
	public @ResponseBody String regist( @RequestParam String member_id, 
										@RequestParam String member_name, 
										@RequestParam String member_pw){
		
		return JSONUtil.getInstance().toJSONString(memberService.createAccount(member_id, member_pw, member_name));
		
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces={"application/json; charset=UTF8"})
	public @ResponseBody String list(   @RequestParam(required=false, defaultValue="1") String page){
		
		return JSONUtil.getInstance().toJSONString(boardService.getBoardList(page)); 
		
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET, produces={"application/json; charset=UTF8"})
	public @ResponseBody String view(   @RequestParam(defaultValue="") String id){
		
		return JSONUtil.getInstance().toJSONString(boardService.getBoardOne(id)); 
		
	}
	
	@RequestMapping(value="/write", method=RequestMethod.PUT, produces={"application/json; charset=UTF8"})
	public @ResponseBody String write(  @RequestParam(defaultValue="") String member_id, 
										@RequestParam(defaultValue="") String title, 
										@RequestParam(defaultValue="") String contents, 
										@RequestParam(defaultValue="") String board_type){
		
		return JSONUtil.getInstance().toJSONString(boardService.addBoard(member_id, title, contents, board_type));
		
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST, produces={"application/json; charset=UTF8"})
	public @ResponseBody String modify( @RequestParam(defaultValue="") String idx, 
										@RequestParam(defaultValue="") String member_id, 
										@RequestParam(defaultValue="") String title, 
										@RequestParam(defaultValue="") String contents, 
										@RequestParam(defaultValue="") String board_type){

		return JSONUtil.getInstance().toJSONString(boardService.updateBoard(idx, member_id, title, contents, board_type));
		
	}
}
