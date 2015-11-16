package com.jpark.restful.util;

import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	public static void main(String[] agrs){
		String temp = "&lt;img style=&quot;border: currentColor; width: 900px; height: 1700px; display: block;&quot; src=&quot;http://www.eppn.co.kr/images/mail/newsletter_20130904.jpg&quot; usemap=&quot;#eppn_news&quot;&gt; &lt;map id=&quot;eppn_news&quot; name=&quot;eppn_news&quot;&gt; &lt;area onclick=&quot;window.open(&39#http://www.eppn.co.kr/eppnshow/eppn_map2.jsp&39#,&39#_blank&39#,&39#width=408, height=508, resizable=no, status=no&39#);&quot; href=&quot;#&quot; shape=&quot;rect&quot; alt=&quot;지도보기&quot; coords=&quot;190,1330,381,1430&quot;&gt;   &lt;area onclick=&quot;window.open(&39#http://www.eppn.co.kr/eppnshow/event_coupon.jsp&39#,&39#_blank&39#,&39#width=600, height=400, resizable=no, status=no&39#)&quot; href=&quot;#&quot; shape=&quot;rect&quot; alt=&quot;&quot; coords=&quot;513,1330,673,1430&quot;&gt;  &lt;/map&gt;";
		temp = changeToHTML(temp);
		System.out.println("temp2 : " + temp);
	}
	public static String changeForHTML(String arg){
		String changeStr = arg;
		try{
			changeStr = changeStr.replaceAll("<", "&lt;");
			changeStr = changeStr.replaceAll(">", "&gt;");
			changeStr = changeStr.replaceAll("\"", "&quot;");
			changeStr = changeStr.replaceAll("\\'", "&#39;");
			changeStr = changeStr.replaceAll("--", "");
		}catch(Exception e){
			System.out.print("changeForHTML Exception !! :: ");
			e.printStackTrace();
		}
		return changeStr;
	}
	public static String changeToHTML(String arg){
		String changeStr = arg;
		try{
			changeStr = changeStr.replaceAll("&lt;", "<");
			changeStr = changeStr.replaceAll("&gt;", ">");
			changeStr = changeStr.replaceAll("&quot;", "\"");
			changeStr = changeStr.replaceAll("&#39;", "'");
			changeStr = changeStr.replaceAll("\'", "'");
			changeStr = changeStr.replaceAll("--", "");
		}catch(Exception e){
			System.out.print("changeToHTML Exception !! :: ");
			e.printStackTrace();
		}
		return changeStr;
	}
	public static void charSet(String str_kr) throws UnsupportedEncodingException{
        String charset[] = {"euc-kr", "ksc5601", "iso-8859-1", "8859_1", "ascii", "UTF-8"};
            
        for(int i=0; i<charset.length ; i++){
            for(int j=0 ; j<charset.length ; j++){
                if(i==j) continue;

      System.out.println(charset[i]+" : "+charset[j]+" :"+new String(str_kr.getBytes(charset[i]),charset[j]));
            }
        }
    }
	public static String[] parseToken(String token, String delim){
		String[] result = null;
		StringTokenizer st = null;
		try{
			st = new StringTokenizer(token, delim);
			result = new String[st.countTokens()];
			int flag = 0;
			while(st.hasMoreTokens()){
				result[flag] = st.nextToken();
				++flag;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public static String NullCheck(Object obj){
		String result = "";
		if(obj != null){
			result = obj.toString();
		}else{
			result = "";
		}
		return result;
	}
	
	public static boolean isNotEmpty(Object arg0){
		boolean flag = false;
		try{
			if(arg0 != null){
				
			}
		}catch(Exception e){
			System.out.print("isNotEmpty Exception !! :: ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static String parseURL(String str){
		String result = "";
		try{
			String regex = "([\\p{Alnum}]+)://([a-z0-9.\\-&/%=?:@#$(),.+;~\\_]+)"; 
			 
			Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); 
			Matcher m = p.matcher(str); 
			result = m.replaceAll("<a href='http://$2' target='_blank' style='text-decoration: underline;color: white;'>http://$2</a>"); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return result; 
	}
}
