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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        User user = new User(name, email, password, userType);

        UserService userService = new UserService();

            int result = userService.addUser(user);

            if (result > 0) {
                response.sendRedirect("index.jsp"); 
            } else {
                request.setAttribute("msg", "Registration failed. Please try again.");
                request.getRequestDispatcher("index.jsp").forward(request, response); // 假设注册页面为register.jsp
            }
    }
}
