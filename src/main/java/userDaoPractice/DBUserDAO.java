package userDaoPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUserDAO implements UserDAO {
	
	private PreparedStatement getAllUsersStatement;
	private PreparedStatement saveUserStatement;
	private PreparedStatement updateUserStatement;
	
	public DBUserDAO(String url, String user, String pw) throws SQLException {
		Connection con = DriverManager.getConnection(url, user, pw);
		getAllUsersStatement = con.prepareStatement("SELECT * FROM users_tbl");
		saveUserStatement = con.prepareStatement("INSERT INTO users_tbl (id, fName, lName, email, address) "
												+ "VALUES (?, ?, ?, ?, ?)");
		updateUserStatement = con.prepareStatement("UPDATE users_tbl SET fName = '?', lName = '?', email='?', address='?' "
												+ "WHERE id = '?'");
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		
		try {
			ResultSet result = getAllUsersStatement.executeQuery();
			while(result.next()) {
				User user = new User();
				user.setId(result.getLong(1));
				user.setfName(result.getString(2));
				user.setlName(result.getString(3));
				user.setEmail(result.getString(4));
				user.setAddress(result.getString(5));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		try {
			saveUserStatement.setLong(1, 1);
			saveUserStatement.setString(2, user.getfName());
			saveUserStatement.setString(3, user.getlName());
			saveUserStatement.setString(4, user.getEmail());
			saveUserStatement.setString(5, user.getAddress());
			saveUserStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}

}
