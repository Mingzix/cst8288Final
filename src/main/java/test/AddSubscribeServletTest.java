package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import servlet.AddSubscribeServlet;

import java.io.IOException;

import food.User;

/**
 * Test class for AddSubscribeServlet.
 * 
 * @author Shuting Wang
 */
public class AddSubscribeServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    private AddSubscribeServlet servlet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        servlet = new AddSubscribeServlet();
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        // Mock a user and request parameters
        User user = new User();
        user.setUid(1); // Assume a valid user ID
        String fid = "10"; // Assume a food item ID

        // Configure mock behavior
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(user);
        when(request.getParameter("fid")).thenReturn(fid);

        // Execute the servlet's doGet method
        servlet.doGet(request, response);

        // Verify a redirect was performed
        verify(response).sendRedirect("StoreListServlet");

    }
}
