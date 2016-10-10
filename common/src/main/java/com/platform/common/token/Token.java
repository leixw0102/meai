package com.platform.common.token;

public class Token {
	static private String secretKey="tour_key";
	static private String splitChar="#";
	
	static public String getToken(String user, String role, String mac) {
		String ret_token="";	 
		String token_src=user+splitChar+role+splitChar+mac ;
		String token_src_md5=token_src+splitChar+secretKey ;
		String token_md5 = Md5Func.md5(token_src_md5.getBytes());
	//	ret_token=token_src+splitChar+token_md5;
		return token_md5;
	}
	static public String getToken(String user, String role) {
		String ret_token="";
		String token_src=user+splitChar+role+splitChar+"" ;
		String token_src_md5=token_src+splitChar+secretKey ;
		String token_md5 = Md5Func.md5(token_src_md5.getBytes());
		//	ret_token=token_src+splitChar+token_md5;
		return token_md5;
	}
	static public Boolean isValid(String token) {
		Boolean ret=false;
		if (token==null || token.isEmpty()){
			return ret;
		}
		
		String [] strList = token.split(splitChar);		
		if (strList.length ==4){
			String token_src=strList[0]+splitChar+strList[1]+splitChar+strList[2]+splitChar+secretKey ;
			String token_md5 = Md5Func.md5(token_src.getBytes());
			if (token_md5.equals(strList[3])){
				ret=true;
			}
		}	 
		return ret;
	} 
	
	public static boolean isValid(String userKey, String t, String m) {
		Boolean ret=false;
		if (t==null || t.isEmpty()){
			return ret;
		}
		if (m==null || m.isEmpty()){
			return ret;
		}
		
		ret = (m.equalsIgnoreCase(getTokenM(t,userKey))?true:false) ;
		return ret;
	}

	public static String getTokenM(String t,String userKey) {
    	String lastChar = t.substring(t.length()-1,t.length());//取最后一个字符
		int i=Integer.parseInt(lastChar);
		String md5String = userKey +t.substring(i);    
		return Md5Func.md5(md5String.getBytes());//求md5值
	}
	
	public static void main(String[] args){
		 
		boolean dddxx =Token. isValid("", "1436064222181",  "1800d8fe88068e1274ad0a0ab117eb53");
		
		
		String   result ="hlj1#2#1389686200545#EDA66D4B8C9826B8459982E39F7246B5";
		//Boolean ret= Token.isValid(result);
	//	System.out.println(ret);
		String x =Token. getToken("112244", "2",  "22");
			   x =Token. getToken("112255", "5",  "22");
			   x =Token. getToken("18911771102", "2",  "22");
			   x =Token. getToken("18911771103", "2",  "22");
			   x =Token. getToken("18911771104", "2",  "22");
			   x =Token. getToken("18911771105", "2",  "22");
			   x =Token. getToken("18911771106", "2",  "22");
			   x =Token. getToken("18911771107", "2",  "22");
			   x =Token. getToken("18911771108", "2",  "22");
			   x =Token. getToken("18911771109", "2",  "22");
		   
	    String xq =Token. getToken("18911771110", "5",  "22");
			   xq =Token. getToken("18911771111", "5",  "22"); 
			   xq =Token. getToken("18911771112", "5",  "22");
			   xq =Token. getToken("18911771113", "5",  "22");
			   xq =Token. getToken("18911771114", "5",  "22");
			   xq =Token. getToken("18911771115", "5",  "22");
			   xq =Token. getToken("18911771116", "5",  "22");
			   xq =Token. getToken("18911771117", "5",  "22");
			   xq =Token. getToken("18911771118", "5",  "22");
			   xq =Token. getToken("18911771119", "5",  "22");
		
		String   result22=Md5Func.md5(result.getBytes())
				
				;	
		System.out.println(result22);
		String   result233=Md5Func.sha1(result.getBytes());	
		System.out.println(result233);
		
		
	}

	
}
