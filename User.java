package user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import code.Queries;
import code.UserDetails;

public class User {
	UserDetails userDetails = new UserDetails();
	ObjectOutputStream out = null;
	ListIterator<UserDetails> iterator = null;
	ObjectInputStream in = null;
	File file = new File("User.txt");
	File file1 = new File("Query.txt");
	Scanner scanner = new Scanner(System.in);
	ArrayList<Queries> list1 = new ArrayList<Queries>();
	// ArrayList<UserDetails> list=new ArrayList<UserDetails>();

	public void recharge(String mobileno, ArrayList<UserDetails> list)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		in = new ObjectInputStream(new FileInputStream(file));
		list = (ArrayList<UserDetails>) in.readObject();
		in.close();
		iterator = list.listIterator();
		boolean flag = true;
		while (iterator.hasNext()) {
			userDetails = (UserDetails) iterator.next();
			if (userDetails.mobileno.equals(mobileno)) {
				flag = false;
				String[] stringArray = userDetails.date.split("-");
				String da = stringArray[0];
				String mon = stringArray[1];
				String ye = stringArray[2];
				int day = Integer.parseInt(da);
				int month = Integer.parseInt(mon);
				int year = Integer.parseInt(ye);
				int currentYear = 2022;
				int dis = currentYear - year;

				char ch = ' ';
				do {
					System.out.println("1:VIEW POPULAR PLANS");

					System.out.println();
					System.out.println("Please choose your plan (-:");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Rs:499 Validity:28 days Data:2GB/day");
						System.out.println("Rs:2999 Validity:365 days Data:2.5GB/day");
						System.out.println("Rs:719 Validity:84 days Data:2GB/day");
						System.out.println();
						System.out.println("Choose Your Plan");
						int rate = scanner.nextInt();
						switch (rate) {
						case 499:
							System.out.println("enter the payment method ");
							System.out.println("1:G-Pay");
							System.out.println("2:Phone-Pe");
							int payment = scanner.nextInt();
							switch (payment) {
							case 1:
								System.out.println();
								if (dis >= 10) {
									System.out.println("10% offer");
									rate = rate - (rate * 10 / 100);
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-1m-2Gb/D" + " is success for your number " + mobileno);
									System.out.println("money " + rate + "debited from your G-Pay Account !!!");
								} else if (dis < 10) {
									System.out.println("5% offer");
									rate = rate - (rate * 5 / 100);
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-1m-2Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your G-Pay Account !!!");
								} else {
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-1m-2Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your G-Pay Account !!!");
								}
								break;
							case 2:
								if (dis >= 10) {
									System.out.println("10% offer");
									rate = rate - (rate * 10 / 100);
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-1m-2Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your Phonepe Account !!!");
								} else if (dis < 10) {
									System.out.println("5% offer");
									rate = rate - (rate * 5 / 100);
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-1m-2Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your Phonepe Account !!!");
								} else {
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-1m-2Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your Phonpe Account !!!");
								}
								break;
							}
							break;
						case 2999:
							System.out.println("enter the payment method ");
							System.out.println("1:G-Pay");
							System.out.println("2:Phone-Pe");
							payment = scanner.nextInt();
							switch (payment) {
							case 1:
								System.out.println();
								if (dis >= 10) {
									System.out.println("10% offer");
									rate = rate - (rate * 10 / 100);
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-12m-2.5Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your G-Pay Account !!!");
								} else if (dis < 10) {
									System.out.println("5% offer");
									rate = rate - (rate * 5 / 100);
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-12m-2.5Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your G-Pay Account !!!");
								} else {
									// System.out.println("1");
									System.out.println("Congratulation " + userDetails.username
											+ " , Your recharged plan Rs" + rate + "-12m-2.5Gb/D"
											+ " is success for your number" + mobileno + "<3");
									System.out.println("money " + rate + "debited from your G-Pay Account !!!");
								}
								break;
							case 2:
								if (dis >= 10) {
									System.out.println("10% offer");
									rate = rate - (rate * 10 / 100);
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-12m-2.5Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your Phonepe Account !!!");
								} else if (dis < 10) {
									System.out.println("5% offer");
									rate = rate - (rate * 5 / 100);
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-12m-2.5Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your Phonepe Account !!!");
								} else {
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-12m-2.5Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your Phonpe Account !!!");
								}
								break;
							}
							break;
						case 719:
							System.out.println("enter the payment method ");
							System.out.println("1:G-Pay");
							System.out.println("2:Phone-Pe");
							payment = scanner.nextInt();
							switch (payment) {
							case 1:
								System.out.println();
								if (dis >= 10) {
									System.out.println("10% offer");
									rate = rate - (rate * 10 / 100);
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-3m-2Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your G-Pay Account !!!");
								} else if (dis < 10) {
									System.out.println("5% offer");
									rate = rate - (rate * 5 / 100);
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-3m-2Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your G-Pay Account !!!");
								} else {
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-3m-2Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your G-Pay Account !!!");
								}
								break;
							case 2:
								if (dis >= 10) {
									System.out.println("10% offer");
									rate = rate - (rate * 10 / 100);
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-3m-2Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your Phonepe Account !!!");
								} else if (dis <= 5) {
									System.out.println("5% offer");
									rate = rate - (rate * 5 / 100);
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-3m-2Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your Phonepe Account !!!");
								} else {
									System.out.println(
											"Congratulation " + userDetails.username + " , Your recharged plan Rs"
													+ rate + "-3m-2Gb/D" + " is success for your number" + mobileno);
									System.out.println("money " + rate + "debited from your Phonpe Account !!!");
								}
								break;
							}
							break;
						}

					}
					System.out.println("Do you want to stay in this page press 'y' otherwise 'n'");
					ch = scanner.next().charAt(0);
				} while (ch == 'y' || ch == 'Y');
			}
		}
	}

	public boolean profile(UserDetails userDetails) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Name : " + userDetails.username);
		System.out.println("Email-Id : " + userDetails.email);
		System.out.println("MobiileNo : " + userDetails.mobileno);
		System.out.println("Joined From : " + userDetails.date);
		System.out.println("Here You can modify your details <3");
		System.out.println("1:Name");
		System.out.println("2:Password");
		System.out.println("3:Email-id");
		char ch;
		boolean flag = false;
		do {

			System.out.println("----------choose the above option-----------");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("enter the name you want to change");
				String newUser = scanner.next();
				userDetails.setUsername(newUser);
				System.out.println("Name changed successfully!!!");
				flag = true;
				break;
			case 2:
				System.out.println("enter the password you want to change");
				String newPassword = scanner.next();
				userDetails.setEmail(newPassword);
				;
				System.out.println("Password changed successfully!!!");
				break;
			case 3:
				System.out.println("enter the email id you want to change");
				String newEmail = scanner.next();
				userDetails.setEmail(newEmail);
				;
				System.out.println("Emailid changed successfully!!!");
				break;
			}
		

			System.out.println("do you want to change again if yes press y otherwise n");
			ch = scanner.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
		
		return flag;
	}

	public ArrayList<Queries> addingFeedback(UserDetails userDetails) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Write Something");
		String feedBack = scanner.nextLine();

		list1.add(new Queries(userDetails.mobileno, feedBack));
		return list1;
		
	}

}
