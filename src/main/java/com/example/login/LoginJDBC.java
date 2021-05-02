package com.example.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginJDBC {
	public boolean validate(LoginConstructor loginusers) throws ClassNotFoundException {
		boolean status = false;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/finalproject?user=root&password=root")){
				// Step 2:Create a statement using connection object
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE username = ? and password = ? ");
			ps.setString(1, loginusers.getUsername());
			ps.setString(2, loginusers.getPassword());

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			// process sql exception
			System.out.println("SQL is not working");
		}
		return status;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}