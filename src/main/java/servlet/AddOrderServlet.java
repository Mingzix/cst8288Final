package servlet;
import java.io.IOException;
import java.math.BigDecimal;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Service.OrderService;
import food.Orders;
import food.User;  

public class AddOrderServlet extends HttpServlet {  
    private OrderService orderService;
  

    public void init() throws ServletException {  
        orderService = new OrderService();
    }  
  
    @Override  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String fidStr = request.getParameter("fid");
        String num = request.getParameter("num");
        String moneyStr = request.getParameter("money");
        Orders orders = new Orders();
        orders.setUid(user.getUid());
        orders.setFid(Integer.parseInt(fidStr));
        if(moneyStr!=null){
            BigDecimal money = new BigDecimal(moneyStr);
            orders.setMoney(money);
        }
        if(num!=null){
            int numInt = Integer.parseInt(num);
            orders.setNum(numInt);
        }
        int result =orderService.addOrder(orders);
        if(result<1){
            request.setAttribute("msg","add orders fail");
        }
        if("consumer".equals(user.getUserType())){
            response.sendRedirect("StoreListServlet");
        }else {
            response.sendRedirect("FoodListServlet");
        }
    }
}