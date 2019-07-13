import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    
    throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Hello world</title></head>");
        out.println("<body><h1> Hello world! </h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
