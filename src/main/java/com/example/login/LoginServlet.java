package com.example.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginJDBC loginJDBC;

	public void init() {
		loginJDBC = new LoginJDBC();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginConstructor loginusers = new LoginConstructor();
		loginusers.setUsername(username);
		loginusers.setPassword(password);
		
		try {
			//if usersname and password is wrong redirect to the front page
			if (!loginJDBC.validate(loginusers)) {
				response.sendRedirect("/login.html");  
			} else {
				//else create a session for it
				//HttpSession session = request.getSession();	
				response.sendRedirect("/loggedinindex.html");  
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}