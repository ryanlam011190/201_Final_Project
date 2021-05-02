package com.example.register;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegisterJDBC usersDao = new RegisterJDBC();
    public RegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get all the request parameter
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String passw = request.getParameter("password");
		
		UsersConstructor usersLogin = new UsersConstructor();
		usersLogin.setEmail(email);
		usersLogin.setUsername(username);
		usersLogin.setPassword(passw);
		
		try {
			usersDao.registerUsers(usersLogin);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		//if successfully created an account
		response.sendRedirect("/loggedinindex.html");  
	}

}