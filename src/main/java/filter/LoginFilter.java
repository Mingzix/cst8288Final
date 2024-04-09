package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
import java.io.IOException;  

/**
 * Filter implementation class LoginFilter
 * @author Zoe Zhou
 */
@WebFilter("/*")
public class LoginFilter implements Filter {  

  	/**
	   * This function handles filter initialization tasks such as loading configuraiton files
	   * @param filterConfig a filter configuration object used by a servlet container to pass information to a filter during initialization.
	   */
    @Override  
    public void init(FilterConfig filterConfig) throws ServletException {  
    }  

    /**
     * Called by the container each time a request/response pair is passed through the chain due to a client request for a resource at the end of the chain.
	   * @param request HttpServletRequest object that provides request information for HTTP servlets
	   * @param response HttpServletResponse object that provides HTTP-specific functionality in sending a response
     * @param chain Filters use the FilterChain to invoke the next filter in the chain, or if the calling filter is the last filter in the chain, to invoke the resource at the end of the chain.
     */
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  
            throws IOException, ServletException {  
        HttpServletRequest httpRequest = (HttpServletRequest) request;  
        HttpServletResponse httpResponse = (HttpServletResponse) response;  
        // Set to false so we don't create new session
        HttpSession session = httpRequest.getSession(false); 
  
        // Fetch the request URI
        String requestURI = httpRequest.getRequestURI();  
  
        // Define allowed resource paths
        String[] allowedPaths = {"/index.jsp", "/LoginServlet", "/RegisterServlet","/"};
  
        // Check request path against allowed list
        boolean isAllowed = false;  
        for (String path : allowedPaths) {  
            if (requestURI.endsWith(path)) {  
                isAllowed = true;  
                break;  
            }  
        }  

        // If requested resource is allowed and session is valid, continue with the filter chain
        if (isAllowed || (session != null && session.getAttribute("user") != null)) {  
            chain.doFilter(request, response);  
        } else {  
            // Otherwise redirect user back to index.jsp and show error message
            httpRequest.setAttribute("msg", "not login");  
            httpRequest.getRequestDispatcher("/index.jsp").forward(httpRequest, httpResponse);  
        }  
    }  

    /**
     *  Called by the web container to indicate to a filter that it is being taken out of service.
     */
    @Override  
    public void destroy() {  
    }  
}