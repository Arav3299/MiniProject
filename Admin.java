package user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

import code.Queries;
import code.UserDetails;

public class Admin {
	UserDetails userDetails = new UserDetails();
	Queries queries = new Queries();
	ObjectOutputStream out = null;
	ListIterator<UserDetails> iterator = null;
	ListIterator<Queries> iterator1 = null;
	ObjectInputStream in = null;
	File file = new File("User.txt");
	File file1 = new File("newUser.txt");
	Scanner scanner = new Scanner(System.in);

	public void viewAllUsers(ArrayList<UserDetails> list)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Here is the list of users");
		in = new ObjectInputStream(new FileInputStream(file));
		list = (ArrayList<UserDetails>) in.readObject();
		in.close();
		iterator = list.listIterator();
		while (iterator.hasNext()) {
			System.out.println();
			System.out.println(iterator.next());
			System.out.println();
		}

	}

	public ArrayList<UserDetails> addingUser(ArrayList<UserDetails> list) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome Admin!!you can add multiple users");
		System.out.println();
		System.out.println("How many users do you want to add");
		int userCount = scanner.nextInt();
		// ArrayList<UserDetails> addList = new ArrayList<UserDetails>();

		for (int i = 0; i < userCount; i++) {
			System.out.println("enter the username");
			String username = scanner.next();
			System.out.println("enter the mobileno");
			String mobileno = scanner.next();
			// System.out.println("enter the password");
			// String password=scanner.next();
			byte[] array = new byte[8]; // length is bounded by
			new Random().nextBytes(array);
			String password = new String(array, Charset.forName("UTF-8"));
			System.out.println(password);
			System.out.println("enter the email");
			String email = scanner.next();
			System.out.println("enter the role");
			String role = scanner.next();
			System.out.println("enter the check-in date in dd-mm-yyyy format");
			String date = scanner.next();

			list.add(new UserDetails(username, mobileno, password, role, email, date));
		}
		out = new ObjectOutputStream(new FileOutputStream(file));// it is used to write the userdetails into file
		out.writeObject(list);
		out.close();
		return list;
	}

	public ArrayList<UserDetails> deleteUser(ArrayList<UserDetails> list)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("-------DELETING--------");
		boolean flag = false;
		System.out.println("Enter the Person mobile number to delete");
		String dlt_mobile = scanner.nextLine();

		in = new ObjectInputStream(new FileInputStream(file));

		// ArrayList<UserDetails> deleteList1 = new ArrayList<UserDetails>();

		list = (ArrayList<UserDetails>) in.readObject();
		in.close();
		ListIterator<UserDetails> iterator2 = list.listIterator();
		;
		// traversing file
		while (iterator2.hasNext()) {
			System.out.println("3");
			// System.out.println(iterator2.next());
			userDetails = (UserDetails) iterator2.next();
			if (userDetails.mobileno.equals(dlt_mobile)) {
				iterator2.remove();
				System.out.println("2");
				flag = true;
				break;
			}
		}
//		
//		boolean flag1 = false;
//		
//		in = new ObjectInputStream(new FileInputStream(file));
//		ArrayList<UserDetails> deleteList2 = new ArrayList<UserDetails>();
//		deleteList2 = (ArrayList<UserDetails>) in.readObject();
//		in.close();//closing file
//		ListIterator<UserDetails>iterator3 =deleteList2.listIterator();;
//		//traversing old file
//		while (iterator3.hasNext()) {
//			System.out.println("4");
//			System.out.println(iterator3.next());
//			userDetails = (UserDetails) iterator3.next();
//			if (userDetails.mobileno.equals(dlt_mobile)) {
//				iterator3.remove();
//				System.out.println("1");
//				//out.writeObject(list);
//				flag1 = true;
//				
//				break;
//			}
//		}

		if (flag) {

			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(list);
			out.close();
			System.out.println(dlt_mobile + " is removed sucessfully from the record");

		}
//		else {
////			System.out.println(dlt_mobile + " is not in a list");
//		     
//			}
//		if (flag1) {
//			out = new ObjectOutputStream(new FileOutputStream(file));
//			out.writeObject(deleteList2);
//			out.close();
//			System.out.println(dlt_mobile + " is removed sucessfully from old record");
//			
//		} 
		else {
			System.out.println(dlt_mobile + " is not in the record");

		}
		return list;

	}

	public boolean viewUserByMobileNumber(ArrayList<UserDetails> list) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("enter the mobile number to search");
		String searchingMobileno = scanner.next();
		in = new ObjectInputStream(new FileInputStream(file));
		list = (ArrayList<UserDetails>) in.readObject();
		in.close();
		iterator = list.listIterator();
		boolean flag = true;
		while (iterator.hasNext()) {

			userDetails = (UserDetails) iterator.next();
			if (userDetails.mobileno.equals(searchingMobileno)) {
				System.out.println("Here is the Userdetails");
				System.out.println();
				System.out.println("Name - " + userDetails.username);
				System.out.println("MobileNo - " + userDetails.mobileno);
				System.out.println("Email id - " + userDetails.email);
				System.out.println("Password - " + userDetails.password);
				System.out.println("Joined from - " + userDetails.date);
				System.out.println();
				flag = false;
				break;
			}
		}

		return flag;
	}

	public ArrayList<UserDetails> modifyUserDetails(ArrayList<UserDetails> list) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		boolean flag = true;
		System.out.println("enter the mobileno to find");
		String mobileno = scanner.next();
		in = new ObjectInputStream(new FileInputStream(file));
		list = (ArrayList<UserDetails>) in.readObject();
		in.close();
		iterator = list.listIterator();
		while (iterator.hasNext()) {
		userDetails=(UserDetails)iterator.next();
		if(userDetails.mobileno.equals(mobileno)){
			System.out.println("what you want to modify");
			System.out.println("1:Username");
			System.out.println("2:Email");
			int choose = scanner.nextInt();
			switch(choose) {
			case 1:
				System.out.println("enter the username to modify");
				String username =scanner.next();
				userDetails.setUsername(username);
				flag=false;
				break;
			case 2:
				System.out.println("enter the email to modify");
				String email =scanner.next();
				userDetails.setEmail(email);
				flag=false;
				break;
			}
			
			
		}
		}
		if(flag) {
			System.out.println("there is no record with this no "+mobileno);
		}else
			System.out.println("user details modified");
		out = new ObjectOutputStream(new FileOutputStream(file));// it is used to write the userdetails into file
		out.writeObject(list);
		out.close();
		return list;
		
		
		
	}

	public void generateFeedbackReport( ArrayList<Queries> list1) throws FileNotFoundException, IOException, 
	ClassNotFoundException {
		// TODO Auto-generated method stub
		//in = new ObjectInputStream(new FileInputStream(file));
		//ArrayList<UserDetails> list = (ArrayList<UserDetails>) in.readObject();
		//in.close();
		//iterator = list.listIterator();
		iterator1=list1.listIterator();
		
				
			while(iterator1.hasNext()) {
				queries=(Queries)iterator1.next();
		
					System.out.println("Name : "+queries.username);
					System.out.println("Her/His FeedBack : "+queries.query);
					
				
			}
			
		
		



	}
}
