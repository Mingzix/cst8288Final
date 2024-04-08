package servlet;

import java.io.IOException;

import Service.UserService;
import food.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;  

public class LoginServlet extends HttpServlet {  
      
    @Override  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        String name = request.getParameter("name");  
        String password = request.getParameter("password");  
          
        UserService userService = new UserService(); 
          
        User user = userService.getUserByNameAndPassword(name, password);
          
        if (user!=null) {
            request.getSession().setAttribute("user", user); 
            userService.updateLastTime(user.getUid());
            if("consumer".equals(user.getUserType())){
                response.sendRedirect("StoreListServlet"); 
            }else {
                response.sendRedirect("FoodListServlet"); 
            }
        } else {   
            request.setAttribute("msg", "Invalid username or password");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }  
    }  
      

}
