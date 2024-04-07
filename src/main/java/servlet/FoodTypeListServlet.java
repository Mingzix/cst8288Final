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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        foodTypeService = new FoodTypeService();
        List<FoodType> foodTypeList = foodTypeService.getAllFoodTypes();
        request.setAttribute("foodTypeList", foodTypeList);
        request.getRequestDispatcher("retailer_add_food.jsp").forward(request, response);
    }
}
