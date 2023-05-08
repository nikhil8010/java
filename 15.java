slip-15
1>
package TYBCS;

public class demo {

		public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		System.out.println("Thread Name: " + thread.getName());
		System.out.println("Thread Priority: " + thread.getPriority());
		}
		}


2>
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class VisitCounterServlet extends HttpServlet {

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      response.setContentType("text/html");

      // Get the user's cookies
      Cookie[] cookies = request.getCookies();

      // Check if the "visitCount" cookie exists
      int visitCount = 0;
      boolean foundCookie = false;
      if (cookies != null) {
         for (Cookie cookie : cookies) {
            if (cookie.getName().equals("visitCount")) {
               visitCount = Integer.parseInt(cookie.getValue());
               foundCookie = true;
               break;
            }
         }
      }

      // If "visitCount" cookie doesn't exist, it's the user's first visit
      if (!foundCookie) {
         visitCount = 1;
         Cookie cookie = new Cookie("visitCount", Integer.toString(visitCount));
         response.addCookie(cookie);
         response.getWriter().println("<h1>Welcome to my page!</h1>");
      }
      else {
         visitCount++;
         Cookie cookie = new Cookie("visitCount", Integer.toString(visitCount));
         response.addCookie(cookie);
         response.getWriter().println("<h1>You have visited this page " + visitCount + " times.</h1>");
      }
   }
}

