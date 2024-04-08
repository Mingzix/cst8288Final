/**
 * The {@code GetFoodByIdServlet} class is a servlet that handles requests for retrieving a food item by its ID.
 * It retrieves the food item using the {@link Service.FoodService} based on the provided food ID.
 * The retrieved food item is then forwarded to the "retailer_edit_food.jsp" page.
 * <p>
 * This servlet is mapped to the URL pattern "/getFoodById".
 * </p>
 * 
 * @author Mingzi Xu
 * @version 2.1
 */
package servlet;

import java.io.IOException;

import Service.FoodService;
import food.FoodVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetFoodByIdServlet
 */
public class GetFoodByIdServlet extends HttpServlet {
	 /**
     * Handles HTTP GET requests.
     * Retrieves the food item using the {@link Service.FoodService} based on the provided food ID.
     * Forwards the retrieved food item to the "retailer_edit_food.jsp" page.
     * 
     * @param req  the {@code HttpServletRequest} object that contains the request the client has made to the servlet
     * @param resp the {@code HttpServletResponse} object that contains the response the servlet sends to the client
     * @throws ServletException if the request for the GET could not be handled
     * @throws IOException      if an input or output error is detected when the servlet handles the GET request
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int fid = Integer.parseInt(req.getParameter("fid"));
        FoodService foodService = new FoodService();
        FoodVo food = foodService.getFoodById(fid);
        req.setAttribute("food", food);
        req.getRequestDispatcher("retailer_edit_food.jsp").forward(req, resp);
    }
}

