package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
import java.io.IOException;  

@WebFilter("/*")
public class LoginFilter implements Filter {  
  
    @Override  
    public void init(FilterConfig filterConfig) throws ServletException {  
        // 初始化方法，可以在这里进行一些初始化操作，比如加载配置文件等  
    }  
  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  
            throws IOException, ServletException {  
        HttpServletRequest httpRequest = (HttpServletRequest) request;  
        HttpServletResponse httpResponse = (HttpServletResponse) response;  
        HttpSession session = httpRequest.getSession(false); // 不创建新的session  
  
        // 获取请求的资源路径  
        String requestURI = httpRequest.getRequestURI();  
  
        // 定义放行的资源路径  
        String[] allowedPaths = {"/index.jsp", "/LoginServlet", "/RegisterServlet","/"};
  
        // 检查是否需要验证session  
        boolean isAllowed = false;  
        for (String path : allowedPaths) {  
            if (requestURI.endsWith(path)) {  
                isAllowed = true;  
                break;  
            }  
        }  
  
        if (isAllowed || (session != null && session.getAttribute("user") != null)) {  
            // 如果是放行资源或者session中有user对象，则继续执行后续过滤器或目标资源  
            chain.doFilter(request, response);  
        } else {  
            // 否则，将请求转发到index.jsp，并设置msg属性  
            httpRequest.setAttribute("msg", "not login");  
            httpRequest.getRequestDispatcher("/index.jsp").forward(httpRequest, httpResponse);  
        }  
    }  
  
    @Override  
    public void destroy() {  
        // 销毁方法，可以在这里进行一些清理操作  
    }  
}