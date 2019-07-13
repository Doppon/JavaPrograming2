import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleServlet extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	String name=request.getParameter("MYNAME");
	response.setContentType("text/html;charset=Shift_JIS");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello world</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Ç±ÇÒÇ…ÇøÇÕ </h1>");
        out.println("<h2>"+name+"Ç≥ÇÒÅAÇ±ÇÒÇ…ÇøÇÕÅI</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}

