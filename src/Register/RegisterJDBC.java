package Register;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegisterJDBC {
	public int registerUsers(UsersConstructor user) throws ClassNotFoundException, SQLException {
		String insert_sql = "INSERT INTO users" + " (email, username, password) VALUES " + " (?,?,?); ";
		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/finalproject?user=root&password=root")) {
			//Prepare statement
			PreparedStatement ps = conn.prepareStatement(insert_sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			
			System.out.println(ps);
			
			//execute query
			result = ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println("cant get SQL");
		}
		return result;
	}
}
