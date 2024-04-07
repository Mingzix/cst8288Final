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
 */
public class EditFoodServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Food food = new Food();
        String fid = req.getParameter("fid");
        food.setFid(Integer.parseInt(fid));
        String expirationParam = req.getParameter("expiration");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 假设日期格式为"年-月-日"
        try {
            Date date = simpleDateFormat.parse(expirationParam);
            food.setExpiration(date);
        }  catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String inventory = req.getParameter("inventory");
        food.setInventory(Integer.parseInt(inventory));
        String discount = req.getParameter("discount");
        food.setDiscount(Double.parseDouble(discount));
        String isDonate = req.getParameter("isDonate");
        if(isDonate!=null){
            food.setIsDonate(Integer.parseInt(isDonate));
        }
        FoodService foodService = new FoodService();
        int updateFood = foodService.updateFood(food);
        if(updateFood>0){
            resp.sendRedirect("FoodListServlet");
        }else{
            req.setAttribute("msg","update fail");
            req.getRequestDispatcher("EditFoodServlet?fid="+fid).forward(req,resp);
        }
    }
}
