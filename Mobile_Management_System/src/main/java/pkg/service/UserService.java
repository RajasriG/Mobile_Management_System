
package pkg.service;

import java.util.List;

import pkg.dto.UserDto;
import pkg.entity.User;

public interface UserService {

	public List<User> getAll();
	
	   public User create(UserDto userdto)throws Exception;
		
		public User update(UserDto userdto);
		

	public 	void deleteById(int id);

	User getUserById(int id);
		 
}