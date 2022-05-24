package code;

import java.io.Serializable;

public class UserDetails implements Serializable {
	
	public String email;
	public String username;
	public String mobileno;
	public String password;
	public String role;
	public String date;
	
	
	public UserDetails() {
		
		super();
		
	}
	public UserDetails(String username, String mobileno, String password, String role,String email,String date) {
		super();
		this.username = username;
		this.mobileno = mobileno;
		this.password = password;
		this.role = role;
		this.email=email;
		this.date=date;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "UserDetails [email=" + email + ", username=" + username + ", mobileno=" + mobileno + ", password="
				+ password + ", role=" + role + ", date=" + date + "]";
	}
	
	
	

}
