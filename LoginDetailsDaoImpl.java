package daoimpl;


import java.util.ArrayList;

import code.UserDetails;
import dao.LoginDetailsDao;
import repository.LoginDetailsDaoRes;

public class LoginDetailsDaoImpl implements LoginDetailsDao{
	
LoginDetailsDaoRes loginDetailsDaoRes;
	
	public LoginDetailsDaoImpl()
	{
		try {
			loginDetailsDaoRes=new LoginDetailsDaoRes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("problem in repository"+e.getMessage());
		}
	}

	@Override
	public boolean signUp() {
		// TODO Auto-generated method stub
		try {
			return loginDetailsDaoRes.signUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("problem in sign up"+e.getMessage());
			return false;
		}
		
	}

	@Override
	public boolean signIn() {
		// TODO Auto-generated method stub
		try {
			return loginDetailsDaoRes.signIn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("problem in sign in"+e.getMessage());
			return false;
		}

	}

}
