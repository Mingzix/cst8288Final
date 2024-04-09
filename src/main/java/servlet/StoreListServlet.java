package servlet;

import food.Store;
import Service.StoreService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * The StoreListServlet class handles requests related to retrieving a list of stores.
 *  @author Tao Chen
 */
public class StoreListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	// Create a StoreService instance to interact with store data
    	StoreService storeService = new StoreService();
    	
        // Retrieve a list of all stores from the StoreService
        List<Store> stores = storeService.getAllStores();
        
        // Set the list of stores as an attribute in the request object
        req.setAttribute("stores",stores);
        
        // Forward the request to the consumer_main.jsp page for further processing
        req.getRequestDispatcher("consumer_main.jsp").forward(req,resp);
    }
}