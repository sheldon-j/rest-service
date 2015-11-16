package com.jpark.restful.util;


public class HSecurity {
	private static HSecurity security;
	private final char HIGH = '헿';
	private final char LOW = '헤';
	private final String DELIMITER = "ㅋ";
	
	public static HSecurity getInstance(){
		if(security == null) security = new HSecurity();
		
		return security;
	}
	
	public String encryptSimplex(String text, int length){
		String cipher = "";
		
		try{
			char[] bytes = text.toCharArray();
			
			if(length > 0){
				for(int i=0; i<bytes.length; i++){
					String binaryText = Integer.toBinaryString(bytes[i]);
					cipher += toCipher(binaryText);
				}
			}else{
				throw new NumberFormatException();
			}
		}catch(Exception e){
			System.out.print("HSecurity encryptSimplex Exception :: >> ");
			e.printStackTrace();
		}
		
		return cipher.length() > length ? cipher.substring(length) : cipher;
	}
	
	public String encrypt(String text){
		String cipher = "";
		
		try{
			char[] bytes = text.toCharArray();
			for(int i=0; i<bytes.length; i++){
				String binaryText = Integer.toBinaryString(bytes[i]);
				cipher += toCipher(binaryText);
			}
		}catch(Exception e){
			System.out.print("HSecurity encrypt Exception :: >> ");
			e.printStackTrace();
		}
		
		return cipher;
	}
	
	public String decrypt(String code){
		String text = "";
		
		try{
			String[] codes = code.split(DELIMITER);
			for(int i=0; i<codes.length; i++){
				char originText = (char) (Integer.valueOf(toText(codes[i]), 2) + '0' - '0');
				text += originText;
			}
		}catch(Exception e){
			System.out.print("HSecurity decrypt Exception :: >> ");
			e.printStackTrace();
		}
		
		return text;
	}
	
	private String toCipher(String code){
		String result = "";
		
		for(int i=0; i<code.length(); i++){
			switch ( code.charAt(i) ){
				case '1' : 
					result += HIGH;
					break;
				case '0' :  
					result += LOW;
					break;
			}
		}
		result += DELIMITER;
		
		return result;
	}
	
	private String toText(String cipher){
		String result = "";
		for(int i=0; i<cipher.length(); i++){
			switch ( cipher.charAt(i) ){
				case HIGH : 
					result += '1';
					break;
				case LOW :  
					result += '0';
					break;
			}
		}
		return result;
	}
	
}
