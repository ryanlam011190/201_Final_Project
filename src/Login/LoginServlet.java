package Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginJDBC loginJDBC;

	public void init() {
		loginJDBC = new LoginJDBC();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("i am in here");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		LoginConstructor loginusers = new LoginConstructor();
		loginusers.setUsername(username);
		loginusers.setPassword(password);
		
		try {
			//if usersname and password is wrong redirect to the front page
			if (!loginJDBC.validate(loginusers)) {
				out.println("invalid username or password");
			} else {
				//else create a session for it
				//HttpSession session = request.getSession();	
				response.sendRedirect("loginConfirmation.html");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
