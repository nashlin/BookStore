package cn.itcast.utils;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class MD5Utils {

	public static String MD(String password){
		
		try {
			MessageDigest md=MessageDigest.getInstance("md5");
			byte[] b=md.digest(password.getBytes());
			
			BASE64Encoder encoder=new BASE64Encoder();
			return encoder.encode(b);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
