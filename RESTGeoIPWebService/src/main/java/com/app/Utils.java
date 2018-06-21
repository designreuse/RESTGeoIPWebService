package com.app;

public class Utils {

	public static long ipToLong(String ip2) {
		String[] ipAddressInArray = ip2.split("\\.");
		long result = 0;
		for (int i = 0; i < ipAddressInArray.length; i++) {
			int power = 3 - i;
			int ip = Integer.parseInt(ipAddressInArray[i]);
			result += ip * Math.pow(256, power);
		}
		return result;
	}
	
}
