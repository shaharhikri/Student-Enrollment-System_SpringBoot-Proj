package demo;
/*
NewUserDetails sample JSON: 
	{ 
	"email":"user@demo.com", 
	"role":"PLAYER", 
	"username":"Demo User", 
	"avatar":"J" 
	}
 */
public class NewUserDetails {

	private String email;
	private String role;
	private String username;
	private String avatar;
	
	public NewUserDetails(){
		this.email = "user@demo.com";
		this.role = "PLAYER";
		this.username = "Demo User";
		this.avatar = "J";
		
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
}
