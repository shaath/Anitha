package com.CodedUit.Tests;


import com.CodedUit.businessmethods.BusinessMethods;

public class LoginTest 
{
	public static void main(String[] args) throws InterruptedException {
		BusinessMethods lt=new BusinessMethods();
		String res=lt.CodedUit_Launch("http://angularjs.realworld.io/#/");
		System.out.println(res);
		res=lt.CodedUit_Login("testingtoolstrainer449@gmail.com", "testingtoolstrainer449@gmail.com");
		System.out.println(res);
//		res=lt.CodedUit_Settings("testingtoolstrainer449@gmail.com");
//		System.out.println(res);
		res=lt.CodedUit_Logout();
		System.out.println(res);
		lt.CodedUi_Close();
	}
	
	
	
}
