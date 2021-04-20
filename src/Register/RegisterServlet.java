package Register;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class submitServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegisterJDBC usersJDBC = new RegisterJDBC();
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get all the request parameter
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String passw = request.getParameter("password");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		System.out.println(email);
		
		UsersConstructor usersConstructor = new UsersConstructor();
		usersConstructor.setEmail(email);
		usersConstructor.setUsername(username);
		usersConstructor.setPassword(passw);
		usersConstructor.setFname(fname);
		usersConstructor.setLname(lname);
		
		try {
			usersJDBC.registerUsers(usersConstructor);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//if successfully created an account
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/registerConfirmation.html");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/registerConfirmation.html");
		dispatch.forward(request, response);
	}

}
