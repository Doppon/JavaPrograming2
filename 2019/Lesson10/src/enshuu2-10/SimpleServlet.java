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
        out.println("<h1> ����ɂ��� </h1>");
        out.println("<h2>"+name+"����A����ɂ��́I</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}

