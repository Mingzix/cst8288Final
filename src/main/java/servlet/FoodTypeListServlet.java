/**
 * The {@code FoodTypeListServlet} class is a servlet that handles requests for retrieving a list of food types.
 * It retrieves all food types using the {@link Service.FoodTypeService} and forwards the list to the "retailer_add_food.jsp" page.
 * <p>
 * This servlet is mapped to the URL pattern "/foodTypeList".
 * </p>
 * 
 * @author Mingzi Xu
 * @version 1.1
 */
package servlet;

import java.io.IOException;
import java.util.List;

import Service.FoodTypeService;
import food.FoodType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FoodTypeListServlet extends HttpServlet {
    private FoodTypeService foodTypeService;
    /**
     * Handles HTTP GET requests.
     * Retrieves all food types using the {@link Service.FoodTypeService} and forwards the list to the "retailer_add_food.jsp" page.
     *
     * @param request  the {@code HttpServletRequest} object that contains the request the client has made to the servlet
     * @param response the {@code HttpServletResponse} object that contains the response the servlet sends to the client
     * @throws ServletException if the request for the GET could not be handled
     * @throws IOException      if an input or output error is detected when the servlet handles the GET request
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        foodTypeService = new FoodTypeService();
        List<FoodType> foodTypeList = foodTypeService.getAllFoodTypes();
        request.setAttribute("foodTypeList", foodTypeList);
        request.getRequestDispatcher("retailer_add_food.jsp").forward(request, response);
    }
}
