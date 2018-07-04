package com.ecd.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncoderByMd5 {

	  //静态方法，便于作为工具类  
	    public static String getMd5(String password) {  
	          try {  
	        	
	              MessageDigest md = MessageDigest.getInstance("MD5");  
	           // 通过使用 update 方法处理数据,使指定的 byte数组更新摘要 
	             md.update(password.getBytes());  
	          // 获得密文完成哈希计算,产生128 位的长整数 
	             byte b[] = md.digest();  
	          // 表示转换结果中对应的字符位置 
	            int i;  
	  
	           StringBuffer buf = new StringBuffer("");  
	             for (int offset = 0; offset < b.length; offset++) {  
	                 i = b[offset];  
                if (i < 0)  
	                     i += 256;  
	               if (i < 16)  
                     buf.append("0");  
	                 buf.append(Integer.toHexString(i));  
	            }  
	             //32位加密  
	            return buf.toString(); 
	            
	        } catch (NoSuchAlgorithmException e) {  
	             e.printStackTrace();  
            return null;  
         }  
	  
	     }  
	      
	    public static void main(String[] args) {      
	         //测试      
	        System.out.println(EncoderByMd5.getMd5("admin"));  
	     }  
}
