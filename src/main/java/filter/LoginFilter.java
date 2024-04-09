package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
import java.io.IOException;  
/**
 * The LoginFilter class implements a filter that intercepts requests to check if the user is logged in.
 * If the user is not logged in and the requested resource requires authentication,
 * the filter redirects the user to the login page.
 * @author Zoe Zhou
 */
@WebFilter("/*")
public class LoginFilter implements Filter {  
	/**
     * Initializes the filter.
     * This method is called by the servlet container when the filter is initialized.
     *
     * @param filterConfig the filter configuration
     * @throws ServletException if an error occurs during initialization
     */
    @Override  
    public void init(FilterConfig filterConfig) throws ServletException {  
        // Initialization tasks can be performed here, such as loading configuration files
    }  
    /**
     * Performs the filtering logic.
     * This method intercepts incoming requests and checks if the user is logged in.
     * If the user is not logged in and the requested resource requires authentication,
     * the filter redirects the user to the login page.
     *
     * @param request  the servlet request
     * @param response the servlet response
     * @param chain    the filter chain
     * @throws IOException      if an I/O error occurs
     * @throws ServletException if a servlet error occurs
     */
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  
            throws IOException, ServletException {  
        HttpServletRequest httpRequest = (HttpServletRequest) request;  
        HttpServletResponse httpResponse = (HttpServletResponse) response;  
        HttpSession session = httpRequest.getSession(false); // Do not create a new session
  
        // Get the requested resource path
        String requestURI = httpRequest.getRequestURI();  
  
        // Define the allowed resource paths
        String[] allowedPaths = {"/index.jsp", "/LoginServlet", "/RegisterServlet","/"};
  
        // Check if session validation is required
        boolean isAllowed = false;  
        for (String path : allowedPaths) {  
            if (requestURI.endsWith(path)) {  
                isAllowed = true;  
                break;  
            }  
        }  
  
        if (isAllowed || (session != null && session.getAttribute("user") != null)) {  
            // If the resource is allowed or the session contains a logged-in user, proceed
            chain.doFilter(request, response);  
        } else {  
            // Otherwise, redirect the user to the login page and set an error message
            httpRequest.setAttribute("msg", "not login");  
            httpRequest.getRequestDispatcher("/index.jsp").forward(httpRequest, httpResponse);  
        }  
    }  
    /**
     * Destroys the filter.
     * This method is called by the servlet container when the filter is being removed from service.
     * It can be used for cleanup tasks.
     */
    @Override  
    public void destroy() {  
        // Cleanup tasks can be performed here
    }  
}