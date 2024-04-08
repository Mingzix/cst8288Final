/**
 * The {@code FoodListServlet} class is a servlet that handles requests for retrieving a list of food items.
 * It retrieves the user's session, store ID, and user type from the request parameters.
 * It then calls the {@link Service.FoodService#getFoodList(String, int, String)} method
 * to fetch the list of food items based on the user type, user ID, and store ID.
 * The retrieved list is set as an attribute in the request, and the appropriate JSP file is forwarded to based on the user type.
 * <p>
 * This servlet is mapped to the URL pattern "/foodList".
 * </p>
 * 
 * @author Mingzi Xu
 * @version 1.0
 */
package servlet;

import java.io.IOException;
import java.util.List;

import Service.FoodService;
import food.FoodVo;
import food.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FoodListServlet extends HttpServlet {
	/**
     * Handles HTTP GET requests.
     * Retrieves the user's session, store ID, and user type from the request parameters.
     * Calls the {@link Service.FoodService#getFoodList(String, int, String)} method
     * to fetch the list of food items based on the user type, user ID, and store ID.
     * Sets the retrieved list as an attribute in the request and forwards to the appropriate JSP file based on the user type.
     *
     * @param req  the {@code HttpServletRequest} object that contains the request the client has made to the servlet
     * @param resp the {@code HttpServletResponse} object that contains the response the servlet sends to the client
     * @throws ServletException if the request for the GET could not be handled
     * @throws IOException      if an input or output error is detected when the servlet handles the GET request
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve user from session
    	User user = (User) req.getSession().getAttribute("user");
    	
        // Get store ID parameter from request
        String storeId = req.getParameter("storeId");
        
        // Get user type
        String userType = user.getUserType();
        
        // Instantiate FoodService to retrieve food list
        FoodService foodService = new FoodService();
        List<FoodVo> foodList = foodService.getFoodList(userType,user.getUid(),storeId);
        
        // Set food list as request attribute
        req.setAttribute("foodList",foodList);
        
        // Forward to appropriate JSP file based on user type
        String path = "";
        if(userType.equals("retailer")){
            path = "retailer_main.jsp";
        }else if(userType.equals("organization")){
            path = "organization_main.jsp";
        }else if(userType.equals("consumer")){
            path = "consumer_food_list.jsp";
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }
}
