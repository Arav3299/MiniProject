package main;

import java.util.Scanner;

import dao.LoginDetailsDao;
import daoimpl.LoginDetailsDaoImpl;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***********Welcome to Support Chat box for Network operator****************");

		

		char ch = ' ';
		LoginDetailsDao LoginDao = new LoginDetailsDaoImpl();// polymorphism
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1: Contact US");
			System.out.println("2: About US");
			System.out.println("3: LinkedIn");
			System.out.println("4: Facebook");
			System.out.println("5: Instagram US");
			System.out.println("6: Sign up");
			System.out.println("7: Sign In");
			System.out.println("8: Log Out");
			System.out.println();
			System.out.println("What you do wish to check from the above list");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.println("Call 420/620 (from your voice number )");
				System.out.println("or from 1800-88-99999 (from other network) | Write to Care@arav.com ");
				System.out.println("| Manage your world of our service with our app | Visit www.arav.com.");
				System.out.println("Fax : 111112222 | Address : Somewhere Under Earth (-:");
				System.out.println("PAN:AABC16363G");
				break;
			case 2:
				System.out.println("This is Support ChatBox For Network Operator");
				System.out.println("And also my mini project");
				break;
			case 3:
				System.out.println("Use this link");
				System.out.println("https://www.linkedin.com/arav");
				break;
			case 4:
				System.out.println("Use this link");
				System.out.println("https://www.facebook.com/arav");
				break;
			case 5:
				System.out.println("Use this link");
				System.out.println("https://www.instagram.com/arav");
				break;
			case 6:
				System.out.println("----------SignUp------------");
				if (LoginDao.signUp()) {
					System.out.println("User created successfully (-:");
				} else
					System.out.println("User not created )-:");
				break;
			case 7:
				System.out.println("------SignIn---------");
				if(LoginDao.signIn()) {
					System.out.println("Email and Password doesn't match");
					System.out.println("Check email and password !!!!!!");
				}
				break;
			case 8:
				System.out.println("comeback when you need any help <3");
				ch='n';
				break;
			default:
				System.out.println("there is no such a option");
				break;

			}

			System.out.println("Do you wish to check other options then press Y");
			ch = scanner.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');
	}

}
