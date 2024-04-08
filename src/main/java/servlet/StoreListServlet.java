package servlet;

import food.Store;
import Service.StoreService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StoreListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StoreService storeService = new StoreService();
        List<Store> stores = storeService.getAllStores();
        req.setAttribute("stores",stores);
        req.getRequestDispatcher("consumer_main.jsp").forward(req,resp);
    }
}