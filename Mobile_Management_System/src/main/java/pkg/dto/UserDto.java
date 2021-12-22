package pkg.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private int id;
	
	@NotEmpty(message = "firstName should not be empty or null")
    private String firstName;
	
	@NotEmpty(message = "lastName should not be empty or null")
    private String lastName;
	
	@NotEmpty(message = "Username should be unique or should not be null")
    private String username;
	
    private String password;
    
    @Pattern(regexp ="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",message="mail id is not valid")
    @NotEmpty(message = "email should not be empty")
    @Email(message = "email should be in correct format and should not be null")
    private String email;
    
    @NotEmpty(message = "role should not be empty")
    private List<String> role;
    
    public void setRole(List<String> role) {
		this.role = role;
	}
    
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", role=" + role + "]";
	}

}