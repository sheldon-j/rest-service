package com.jpark.restful.util;

import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;

public class JSONUtil {
	private static JSONUtil jsonUtil;
	
	public static JSONUtil getInstance(){
		if( jsonUtil == null ) jsonUtil = new JSONUtil();
		
		return jsonUtil;
	}
	
	public String toJSONString(Map map){
		JSONObject obj = new JSONObject();
		Iterator itor = map.keySet().iterator();
		
		while(itor.hasNext()){
			String temp = itor.next().toString();
			obj.put(temp, map.get(temp));
		}
		
		return obj.toString();
	}
}
