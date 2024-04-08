package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Service.FoodService;
import food.Food;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FoodAddServlet
 * 
 * <p>This servlet handles the editing of a food item in the database.</p>
 * @author Mingzi Xu
 * @version 2.1
 * @since March 28, 2024
 */
public class FoodAddServlet extends HttpServlet {
	 /*
     * Handles the POST request to add a new food item.
     * 
     * @param request The HTTP servlet request containing the details of the new food item.
     * @param resp The HTTP servlet response used to redirect the user after addition.
     * @throws ServletException If an error occurs while processing the servlet request.
     * @throws IOException If an I/O error occurs while processing the servlet request.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // Create a new Food object to store the details of the new food item
    	Food food = new Food();
        // Retrieve the parameters from the request
        String fname = request.getParameter("fname");
        String expirationParam = request.getParameter("expiration");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        // Parse the expiration date parameter and set it in the Food object
        try {
            Date date = simpleDateFormat.parse(expirationParam);
            food.setExpiration(date);
        }  catch (ParseException e) {
            throw new RuntimeException(e);
        }
        // Retrieve other parameters and set them in the Food object
        String price = request.getParameter("price");
        String inventory = request.getParameter("inventory");
        String discount = request.getParameter("discount");
        String ftid = request.getParameter("ftid");
        food.setFname(fname);
        food.setPrice(new BigDecimal(price));
        food.setInventory(Integer.parseInt(inventory));
        food.setDiscount(Double.parseDouble(discount));
        food.setFtid(Integer.parseInt(ftid));
        // Instantiate FoodService to perform the addition of the food item
        FoodService foodService = new FoodService();
        // Call the addFood method and store the result
        int result = foodService.addFood(food);
        // Redirect to FoodListServlet if addition is successful, otherwise forward to FoodTypeListServlet
        if(result == 1){
            resp.sendRedirect("FoodListServlet");
        }else{
            request.setAttribute("msg","add fail");
            request.getRequestDispatcher("FoodListServlet").forward(request,resp);
        }
    }
}
