package servlet;

import java.io.IOException;

import Service.UserService;
import food.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;  

/**
 * Servlet implementation class LoginServlet
 * @author Zoe Zhou
 */
public class LoginServlet extends HttpServlet {  
      
	/**
	 * This function handles servlet requests made over HTTP POST method
	 * @param request HttpServletRequest object that provides request information for HTTP servlets
	 * @param response HttpServletResponse object that provides HTTP-specific functionality in sending a response
	 */
    @Override  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Retrieve name parameter from the POST request
        String name = request.getParameter("name");  
        // Retrieve password parameter from the POST request
        String password = request.getParameter("password");  
          
        // Instantiate UserService to perform credentials verification against DB
        UserService userService = new UserService(); 
          
        // Invoke getUserByNameAndPassword method to lookup the username and password combination in the DB
        User user = userService.getUserByNameAndPassword(name, password);
          
        // If the previous lookup returns a User object, the credentials entered are verified.
        if (user!=null) {
            // Save user object into session for future reference
            request.getSession().setAttribute("user", user); 
            
            // Update user's last login timestamp in DB
            userService.updateLastTime(user.getUid());
            
            // Redirect the user to different pages based on user's role (UserType)
            if("consumer".equals(user.getUserType())){
                response.sendRedirect("StoreListServlet"); // Store List Page
            }else {
                response.sendRedirect("FoodListServlet"); // Food List Page
            }
        } else {  
            // Authentication failure. Send user back to the sign-in page.
            request.setAttribute("msg", "Invalid username or password");
            request.getRequestDispatcher("index.jsp").forward(request, response); 
        }  
    }  
}
