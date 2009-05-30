package com.test;

public class testmain {
	
	public static void main(String arg[]) {
		String cc="aaaa:bbbb:cccc:dddd:::";
		String[] split = cc.split(":");
		for (String a:split) {
			if (null == a) {
			System.out.println("kongde");}
			else if ("".equals(a)) {
				System.out.println("kongdeaaaaa");
			}
			else {
				System.out.println(a);}
		}
	}

}
