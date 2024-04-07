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
 */
public class FoodAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Food food = new Food();
        String fname = request.getParameter("fname");
        String expirationParam = request.getParameter("expiration");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 假设日期格式为"年-月-日"
        try {
            Date date = simpleDateFormat.parse(expirationParam);
            food.setExpiration(date);
        }  catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String price = request.getParameter("price");
        String inventory = request.getParameter("inventory");
        String discount = request.getParameter("discount");
        String ftid = request.getParameter("ftid");
        food.setFname(fname);
        food.setPrice(new BigDecimal(price));
        food.setInventory(Integer.parseInt(inventory));
        food.setDiscount(Double.parseDouble(discount));
        food.setFtid(Integer.parseInt(ftid));
        FoodService foodService = new FoodService();
        int result = foodService.addFood(food);
        if(result == 1){
            resp.sendRedirect("FoodListServlet");
        }else{
            request.setAttribute("msg","add fail");
            request.getRequestDispatcher("FoodTypeListServlet").forward(request,resp);
        }
    }
}
