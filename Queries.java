package code;

import java.io.Serializable;

public class Queries implements Serializable {

	public String query;
	public String username;
	
	public Queries() {
		super();
	}
	
	public Queries(String username,String query) {
		this.username=username;
		this.query=query;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Queries [query=" + query + ", username=" + username + "]";
	}
	
	
	
}
