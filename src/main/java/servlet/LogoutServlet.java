package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LogoutServlet
 * @author Zoe Zhou
 */
public class LogoutServlet extends HttpServlet {
	/**
	 * This function handles servlet requests made over HTTP GET method
	 * @param req HttpServletRequest object that provides request information for HTTP servlets
	 * @param resp HttpServletResponse object that provides HTTP-specific functionality in sending a response
	 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// Invalidate current user's session
        req.getSession().invalidate();
        
        // Redirect user back to login page
        resp.sendRedirect("index.jsp");
    }
}

