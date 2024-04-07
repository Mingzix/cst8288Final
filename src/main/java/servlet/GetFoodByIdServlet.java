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
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int fid = Integer.parseInt(req.getParameter("fid"));
        FoodService foodService = new FoodService();
        FoodVo food = foodService.getFoodById(fid);
        req.setAttribute("food", food);
        req.getRequestDispatcher("retailer_edit_food.jsp").forward(req, resp);
    }
}

