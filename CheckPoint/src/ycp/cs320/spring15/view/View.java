package ycp.cs320.spring15.view;

import java.util.Scanner;

public class View {
	public static void main(String [] args)
	{
		login();
			
	}
	
	public static void login() {
		Scanner sc = new Scanner(System.in);
		String user;
		String pass;
		System.out.println("Welcome to CheckPoint");
		System.out.println("Enter in your Username");
		user = sc.nextLine();
		System.out.println("Enter in your Password");
		pass = sc.nextLine();
	}
}
