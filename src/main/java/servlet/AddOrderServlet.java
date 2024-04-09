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
/**
 * The AddOrderServlet class handles requests related to adding orders.
 *  @author Tao Chen
 */
public class AddOrderServlet extends HttpServlet {  
    private OrderService orderService;
  
    /**
     * Initializes the servlet.
     * Called by the servlet container to indicate to a servlet that the servlet is being placed into service.
     *
     * @throws ServletException if an exception occurs that interrupts the servlet's normal operation
     */
    public void init() throws ServletException {  
        orderService = new OrderService();
    }  
  
    @Override  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	// Retrieve the user from the session
    	User user = (User) request.getSession().getAttribute("user");
    	
        // Retrieve order details from request parameters
        String fidStr = request.getParameter("fid");
        String num = request.getParameter("num");
        String moneyStr = request.getParameter("money");
        
        // Create an Orders object to represent the order
        Orders orders = new Orders();
        orders.setUid(user.getUid());
        orders.setFid(Integer.parseInt(fidStr));
        
        // Set the order amount if provided
        if(moneyStr!=null){
            BigDecimal money = new BigDecimal(moneyStr);
            orders.setMoney(money);
        }
        
        // Set the order quantity if provided
        if(num!=null){
            int numInt = Integer.parseInt(num);
            orders.setNum(numInt);
        }
        
        // Add the order and retrieve the result
        int result =orderService.addOrder(orders);
        
        // Set an error message if the order addition fails
        if(result<1){
            request.setAttribute("msg","add orders fail");
        }
        
        // Redirect the user based on their user type
        if("consumer".equals(user.getUserType())){
            response.sendRedirect("StoreListServlet");
        }else {
            response.sendRedirect("FoodListServlet");
        }
    }
}