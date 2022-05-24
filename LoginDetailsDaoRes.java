package repository;

import validator.PassWordValidator;
import validator.UserNameValidator;
import validator.EmailValidator;
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
import user.Admin;
import user.User;

public class LoginDetailsDaoRes {
	Scanner scanner = new Scanner(System.in);
	ArrayList<UserDetails> list = new ArrayList<UserDetails>();
	ArrayList<Queries> list1 = new ArrayList<Queries>();
	ObjectOutputStream out = null;
	ListIterator<UserDetails> iterator = null;
	UserDetails userDetails = new UserDetails();
	File file = new File("User.txt");
	File file1 = new File("Query.txt");
	boolean flag;
	Admin admin = new Admin();
	User user = new User();

	public boolean signUp() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter the role");
		String role = scanner.next();
		System.out.println("Enter the Mobile number");
		String mobilenumber = scanner.next();
		System.out.println("Please enter the check-in date in the format('dd-mm-yyyy')");
		String date = scanner.next();
		System.out.println("Enter the username");
		String username = scanner.next();
		if (UserNameValidator.userNameValidation(username)) {
			System.out.println("valid username");
			System.out.println("Enter the Email");
			String email = scanner.next();
			if (EmailValidator.emailValidation(email)) {
				System.out.println("valid email");
				System.out.println("Enter the Password");
				String password = scanner.next();
				if (PassWordValidator.passWordValidation(password)) {
					System.out.println("valid password");
					System.out.println("Enter the confirmpassword");
					String confirmPassword = scanner.next();
					if (password.equals(confirmPassword)) {
						// added
						list.add(new UserDetails(username, mobilenumber, password, role, email, date));
						ObjectOutputStream out = null;
						out = new ObjectOutputStream(new FileOutputStream(file));
						out.writeObject(list);
						out.close();
						flag = true;
					} else {
						System.out.println("Passsword does not match");
						flag = false;
					}
				} else {
					System.out.println("Enter a valid password");
					flag = false;
				}
			} else {
				System.out.println("Not a valid emailID");
				flag = false;
			}
		} else {
			System.out.println("not a valid username");
			flag = false;
		}
		if (flag == true) {
			return flag;
		} else {
			return flag;
		}
	}

	public boolean signIn() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("enter the email");
		String signinEmail = scanner.next();
		System.out.println("enter the password");
		String signinPassword = scanner.next();
		ObjectInputStream in = null;
		in = new ObjectInputStream(new FileInputStream(file));
		ListIterator<UserDetails> iterator = null;
		list = (ArrayList<UserDetails>) in.readObject();// type casting
		in.close();
		iterator = list.listIterator();
		//System.out.println("4");
		boolean flag = true;
		while (iterator.hasNext()) {
			userDetails = (UserDetails) iterator.next();
			// System.out.println("7");
			if (signinEmail.equals(userDetails.email)&&signinPassword.equals(userDetails.password)) {
				System.out.println("Login Successfully");
				flag = false;
				// operations
				if (userDetails.role.equals("admin")) {
					char ch = ' ';
					// Admin.operations();
					System.out.println("admin");
					do {
						System.out.println("***************************************************");
						System.out.println("****** HII Admin!YOU CAN DO BELOW ACTIONS <3******");
						System.out.println("***************************************************");
						System.out.println("1: ADD USERS");
						System.out.println("2: DELETE USER");
						System.out.println("3: VIEW ALL USERS");
						System.out.println("4: VIEW PARTICULAR USER");
						System.out.println("5: MODIFY USER DETAILS");
						System.out.println("6: GENERATE FEEDBACK REPORT");
						System.out.println("***************************************************");
						System.out.println();
						System.out.println("What you do wish to check from the above list");
						int option = scanner.nextInt();
						switch (option) {
						case 1:
							if (admin.addingUser(list) == null) {
								System.out.println("Not added");
							} else {
								System.out.println("Added");
							}
							break;
						case 2:
							admin.deleteUser(list);
							break;
						case 3:
							admin.viewAllUsers(list);
							break;
						case 4:
							if (admin.viewUserByMobileNumber(list)) {
								System.out.println("There is no user with the mobileno which you have typed");
							}
							break;
						case 5:
							admin.modifyUserDetails(list);
							break;
						case 6:
							admin.generateFeedbackReport(list1);
							break;
							default:
								System.out.println("there is no such a option");
						}

						System.out.println("do you want to contiue admin operations then press 'y'");
						ch = scanner.next().charAt(0);
					} while (ch == 'y' || ch == 'Y');
					break;
				} else if (userDetails.role.equals("user")) {
					System.out.println("User");				
					flag = false;
					char ch=' ';
					do {
						System.out.println("***************************************************");
						System.out.println("****** HII User!WELCOME TO OUR SUPPORT SERVICE <3******");
						System.out.println("***************************************************");
						System.out.println("1: PROFILE");
						System.out.println("2: RECHARGE");
						System.out.println("3: HELP & SUPPORT");
						System.out.println("Enter the option to continue from the above list");
						int choice=scanner.nextInt();
						switch(choice) {
						case 1:
							if(user.profile(userDetails)) {
								
									// list.add(userDetails);
									out = new ObjectOutputStream(new FileOutputStream(file));									out.writeObject(list);
									out.close();
								}
							break;
						case 2:
							System.out.println("enter the mobileno");
							String mobileno=scanner.next();
							user.recharge(mobileno,list);
							break;
						case 3:
							System.out.println("Anything you would like to share ?");
							out = new ObjectOutputStream(new FileOutputStream(file1));// it is used to write the userdetails into
							out.writeObject(list1=user.addingFeedback(userDetails));
							out.close();
							
						default:
							System.out.println("there is no such a option");
						}
						System.out.println("if you want to continue user operation press 'y' otherwise 'n'");
					ch=scanner.next().charAt(0);
				}while(ch=='y'||ch=='Y');

			}
			}
		
		

	}
		return flag;
}
}