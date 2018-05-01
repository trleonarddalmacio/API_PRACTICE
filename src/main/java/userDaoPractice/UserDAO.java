package userDaoPractice;

import java.util.List;

public interface UserDAO {
	
	public List<User> getAllUsers();
	public User getUser(Long id);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(Long id);
	
}
