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
/**
 * Servlet implementation class FoodListServlet
 * 
 * <p>This servlet handles the food list from the database.</p>
 * 
 * @version 1.2
 * @since March 28, 2024
 */
public class FoodListServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String storeId = req.getParameter("storeId");
        String userType = user.getUserType();

        FoodService foodService = new FoodService();
        List<FoodVo> foodList = foodService.getFoodList(userType,user.getUid(),storeId);
        req.setAttribute("foodList",foodList);
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
