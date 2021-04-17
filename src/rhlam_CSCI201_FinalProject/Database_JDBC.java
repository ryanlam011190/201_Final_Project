package rhlam_CSCI201_FinalProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database_JDBC {
	private Connection con = null;
	//------------------------------------CONNECTION SECTION----------------------------------------
	public boolean connection() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/finalproject?user=root&password=root");
			return true;
		} catch (SQLException s) {
			System.out.println("cant connect");
			return false;
		}
	}
	
	////Front end will use jquery to get what the user types in and back_end will add this info into the database.
	
	//-------------------------------------REGISTER SECTION------------------------------------------
	public void register(String username, String password, String email, String fname, String lname) {
	
		/* 	
		 * 							This SQL is already tested in the DB and it works
		 * INSERT users SET username = 'rhlam', passw ='1234567', usc_email ='rhlam@usc.edu', fname='ryan', lname ='lam';	
		 */
		
		String user_info_query = "INSERT users SET username = ?, passw = ?, usc_email = ?, fname = ?, lname = ?";
		
		//prepare statement section to avoid hacking
		try(PreparedStatement ps = con.prepareStatement(user_info_query)) {
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, fname);
			ps.setString(5, lname);
			ps.executeUpdate(); //because we are updating a new user
		}catch(SQLException s) {
			System.out.println("cant create new username");
		}
	}
	
	//-------------------------------------LOGIN SECTION------------------------------------------
	public int login(String username, String password) {
		
		/* 	
		 * 				This SQL is already tested in the DB and it works
		 * SELECT users.ID FROM users WHERE username ='rhlam' AND passw ='1234567';
		 */
		
		String user_info_query = "SELECT users.ID FROM users WHERE username = ? AND passw = ?;";
		
		//prepare statement section to avoid hacking
		try(PreparedStatement ps = con.prepareStatement(user_info_query)) {
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet r = ps.executeQuery(); //this is to get the ID of username and password in database for the front end
			r.next();
			return r.getInt(1);
		}catch(SQLException s) {
			System.out.println("Cannot login with your username and password");
			return -23231;
		}
	} 
}

