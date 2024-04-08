package servlet;

import java.io.IOException;

import Service.SubscribeService;
import food.Subscribe;
import food.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveSubscribeServlet
 */
public class RemoveSubscribeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String fid = req.getParameter("fid");
        Subscribe subscribe = new Subscribe();
        subscribe.setUid(user.getUid());
        subscribe.setFid(Integer.parseInt(fid));
        SubscribeService subscribeService = new SubscribeService();
        int result = subscribeService.removeSubscribe(subscribe);
        if (result<1) {
            req.setAttribute("msg", "remove subscribe fail");
        }
        resp.sendRedirect("StoreListServlet");
    }
}

