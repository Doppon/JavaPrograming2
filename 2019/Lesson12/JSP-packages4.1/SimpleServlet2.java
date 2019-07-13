import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	//JSPのURL
	String url="/output.jsp";
	RequestDispatcher dispatcher
                   =getServletContext().getRequestDispatcher(url);
	dispatcher.forward(request, response);
    }
}