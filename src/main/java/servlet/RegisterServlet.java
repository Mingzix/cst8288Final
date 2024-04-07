package servlet;

import java.io.IOException;

import Service.UserService;
import food.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 从请求中获取参数  
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        // 封装成User对象  
        User user = new User(name, email, password, userType);

        // 创建UserService实例  
        UserService userService = new UserService();

            // 调用UserService的register方法完成注册
            int result = userService.addUser(user);

            if (result > 0) {
                // 注册成功，重定向到登录页面或显示成功信息
                response.sendRedirect("index.jsp"); // 假设登录页面为login.jsp
            } else {
                // 注册失败，显示错误信息  
                request.setAttribute("msg", "Registration failed. Please try again.");
                request.getRequestDispatcher("index.jsp").forward(request, response); // 假设注册页面为register.jsp
            }
    }
}
