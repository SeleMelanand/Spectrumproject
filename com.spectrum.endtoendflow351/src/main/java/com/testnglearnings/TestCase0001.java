package com.testnglearnings;

import org.testng.annotations.Test;

public class TestCase0001 {
	
	public static String a = "hello "; 
	public String b = "world";
	
	public static void staticmethod(){
			TestCase0001 tc03 = new TestCase0001();
			String c = a.concat(tc03.b);
			System.out.println(c);
		}
	
	public void nonstaticmethod(){
		String d = a.concat(b);
		System.out.println(d);		
	}
	
	public static void main(String[] args){
		staticmethod();
		TestCase0001 tc03 = new TestCase0001();
		tc03.nonstaticmethod();
		
	}
	
}
