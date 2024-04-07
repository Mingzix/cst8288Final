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

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String userType = user.getUserType();

        FoodService foodService = new FoodService();
        List<FoodVo> foodList = foodService.getFoodList(userType,user.getUid());
        req.setAttribute("foodList",foodList);
        String path = "";
        if(userType.equals("retailer")){
            path = "retailer_main.jsp";
        }else if(userType.equals("organization")){
            path = "organization_main.jsp";
        }else if(userType.equals("consumer")){
            path = "consumer_main.jsp";
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }
}
