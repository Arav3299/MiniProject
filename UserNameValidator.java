package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserNameValidator {

	public static boolean userNameValidation(String username)
    {
    String regex="^[a-zA-Z][a-zA-z0-9_]{6,19}$";
    Pattern p=Pattern.compile(regex);
    if(username==null)
    	System.out.println("enter username!it is empty");
    Matcher m=p.matcher(username);
    
    return m.matches();
	}
}
