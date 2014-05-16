package cn.itcast.utils;

import java.util.UUID;

public class IDUtils {
	
	public static String generateID(){
		return UUID.randomUUID().toString();
	}
}
