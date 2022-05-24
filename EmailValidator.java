package validator;
import java.util.regex.*;


	public class EmailValidator {

		public static boolean emailValidation(String username)
	    {
	    String regex="^(.+)@(.+)$";
	    Pattern pattern = Pattern.compile(regex);
	    
	    if(username==null)
	    	System.out.println("You cannot enter a empty username");
	    Matcher matcher = pattern.matcher(username);
	    
	    return matcher.matches();
		}

		
	}

