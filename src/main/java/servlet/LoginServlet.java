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
          
        UserService userService = new UserService(); // 假设getConnection()方法返回数据库连接
          
        // 调用UserService的validateUser方法进行登录校验  
        User user = userService.getUserByNameAndPassword(name, password);
          
        // 根据校验结果返回响应  
        if (user!=null) {
            // 登录成功，设置session或其他认证方式  
            request.getSession().setAttribute("user", user); // 示例：将用户名存入session
            response.sendRedirect("FoodListServlet"); // 重定向到成功页面
        } else {  
            // 登录失败，返回错误信息  
            request.setAttribute("msg", "Invalid username or password");
            request.getRequestDispatcher("index.jsp").forward(request, response); // 转发回登录页面
        }  
    }  
      

}