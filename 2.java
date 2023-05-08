	********* 'N' name of frnd ascending order *******



package TYBCS;
import java.util.*;
public class slip2_1 {
public static void main(String args[])
{
// Creating a HashSet
HashSet<String> set = new HashSet<String>();
// Adding elements into HashSet using add()
set.add("ram");
set.add("shyam");
set.add("raj");
set.add("vikul");
System.out.println("Original HashSet: "
+ set);
// Sorting HashSet using List
List<String> list = new ArrayList<String>(set);
Collections.sort(list);
// Print the sorted elements of the HashSet
System.out.println("HashSet elements "
+ "in sorted order "
+ "using List: "
+ list);
}
}


	******* information about HTTP ********
	
	
	
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request-info")
public class RequestInfoServlet extends HttpServlet
 {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get request information
        String clientIP = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");

        // Get server information
        String serverName = InetAddress.getLocalHost().getHostName();
        String osName = System.getProperty("os.name");
        String servlets = "";
        Enumeration<String> servletNames = getServletContext().getServletNames();
        while(servletNames.hasMoreElements())
      {
            servlets += servletNames.nextElement() + ", ";
        }
        if(servlets.length() > 2) 
{
            servlets = servlets.substring(0, servlets.length() - 2);
   }

        // Generate HTML output
        out.println("<html>");
        out.println("<head><title>Request Information</title></head>");
        out.println("<body>");
        out.println("<h1>Request Information</h1>");
        out.println("<p>Client IP Address: " + clientIP + "</p>");
        out.println("<p>Browser User Agent: " + userAgent + "</p>");
        out.println("<p>Server Name: " + serverName + "</p>");
        out.println("<p>Operating System: " + osName + "</p>");
        out.println("<p>Loaded Servlets: " + servlets + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}

