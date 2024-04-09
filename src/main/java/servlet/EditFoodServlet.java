package servlet;

import java.io.IOException;
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
 * Servlet implementation class EditFoodServlet
 * 
 * <p>This servlet handles the editing of a food item in the database.</p>
 * @author Mingzi Xu
 * @version 1.1
 * @since March 28, 2024
 */
public class EditFoodServlet extends HttpServlet {
	/*
     * Handles the POST request to edit a food item.
     * 
     * @param req The HTTP servlet request containing the details of the food item to be edited.
     * @param resp The HTTP servlet response used to redirect the user after editing.
     * @throws ServletException If an error occurs while processing the servlet request.
     * @throws IOException If an I/O error occurs while processing the servlet request.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create a new Food object to store the edited details of the food item
    	Food food = new Food();
        // Retrieve the fid parameter from the request and set it in the Food object
        String fid = req.getParameter("fid");
        food.setFid(Integer.parseInt(fid));
        // Retrieve the expiration date parameter from the request, parse it, and set it in the Food object
        String expirationParam = req.getParameter("expiration");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        try {
            Date date = simpleDateFormat.parse(expirationParam);
            food.setExpiration(date);
        }  catch (ParseException e) {
            throw new RuntimeException(e);
        }
        
        // Retrieve the inventory parameter from the request and set it in the Food object
        String inventory = req.getParameter("inventory");
        food.setInventory(Integer.parseInt(inventory));
        // Retrieve the discount parameter from the request and set it in the Food object
        String discount = req.getParameter("discount");
        food.setDiscount(Double.parseDouble(discount));
        // Retrieve the isDonate parameter from the request and set it in the Food object if present
        String isDonate = req.getParameter("isDonate");
        if(isDonate!=null){
            food.setIsDonate(Integer.parseInt(isDonate));
        }
        
        // Instantiate FoodService to perform the update of the food item
        FoodService foodService = new FoodService();
        // Redirect to FoodListServlet if update is successful, otherwise forward to EditFoodServlet with the fid parameter
        int updateFood = foodService.updateFood(food);
        if(updateFood>0){
            resp.sendRedirect("FoodListServlet");
        }else{
            req.setAttribute("msg","update fail");
            req.getRequestDispatcher("EditFoodServlet?fid="+fid).forward(req,resp);
        }
    }
}
