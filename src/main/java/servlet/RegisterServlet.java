package servlet;

import java.io.IOException;

import Service.UserService;
import food.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 * @author Zoe Zhou
 */
public class RegisterServlet extends HttpServlet {

	/**
	 * This function handles servlet requests made over HTTP POST method
	 * @param request HttpServletRequest object that provides request information for HTTP servlets
	 * @param response HttpServletResponse object that provides HTTP-specific functionality in sending a response
	 */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Fetch parameters name, email, password and userType from the HTTP request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        // Construct a User object
        User user = new User(name, email, password, userType);

        // Instantiate UserService class
        UserService userService = new UserService();

            // Invoke addUser method to add the user entity into DB and save the return value into result
            int result = userService.addUser(user);

            if (result > 0) {
                // Redirect the user back to login page when successful
                response.sendRedirect("index.jsp"); 
            } else {
                // Redirect the user back to login page and show error message
                request.setAttribute("msg", "Registration failed. Please try again.");
                request.getRequestDispatcher("index.jsp").forward(request, response); 
            }
    }
}
