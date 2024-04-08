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
 * Handles requests for removing subscriptions. Retrieves subscription details from the request,
 * then uses SubscribeService to remove the specified subscription. Redirects to StoreListServlet post-operation,
 * setting an error message on failure.
 * 
 * @author Shuting Wang
 */
public class RemoveSubscribeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the logged-in user and the food item ID from the request parameters.
        User user = (User) req.getSession().getAttribute("user");
        String fid = req.getParameter("fid");

        // Setup the subscription object to be removed based on the user and food item ID.
        Subscribe subscribe = new Subscribe();
        subscribe.setUid(user.getUid());
        subscribe.setFid(Integer.parseInt(fid));

        // Use the SubscribeService to remove the specified subscription.
        SubscribeService subscribeService = new SubscribeService();
        int result = subscribeService.removeSubscribe(subscribe);

        // If the removal was unsuccessful, set an error message in the request.
        if (result < 1) {
            req.setAttribute("msg", "remove subscribe fail");
        }

        // Redirect to the StoreListServlet after attempting to remove the subscription.
        resp.sendRedirect("StoreListServlet");
    }
}


