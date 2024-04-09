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
 * Handles the addition of subscriptions via GET requests. Retrieves user and subscription data,
 * creates a subscription, and attempts to add it to the database using SubscribeService.
 * On success, redirects to a store list; on failure, sets an error message for the user.
 * 
 * @author Shuting Wang
 */
public class AddSubscribeServlet extends HttpServlet {
    @Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the user from the session and the food item ID (fid) from the request parameters.
        User user = (User) req.getSession().getAttribute("user");
        String fid = req.getParameter("fid");

        // Create a new Subscribe object and set its user ID and food item ID based on the retrieved information.
        Subscribe subscribe = new Subscribe();
        subscribe.setUid(user.getUid());
        subscribe.setFid(Integer.parseInt(fid));

        // Instantiate the SubscribeService and add the subscription.
        SubscribeService subscribeService = new SubscribeService();
        int addSubscribe = subscribeService.addSubscribe(subscribe);

        // Check the result of the subscription addition operation.
        if (addSubscribe < 1) {
            // If the addition failed, set an error message attribute in the request.
            req.setAttribute("msg", "subscribe fail");
        }

        // Redirect to the StoreListServlet for subsequent processing.
        resp.sendRedirect("StoreListServlet");
    }
}
