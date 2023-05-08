slip-19
1>
import java.util.LinkedList;
import java.util.Scanner;
public class NegativeIntegersInLinkedList {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
LinkedList<Integer> list = new LinkedList<Integer>();System.out.print("Enter the number of integers: ");
int n = sc.nextInt();
System.out.println("Enter " + n + " integers:");
for (int i = 0; i < n; i++) {
int num = sc.nextInt();
list.add(num);
}
System.out.println("Negative Integers:");
for (int i : list) {
if (i < 0) {
System.out.println(i);
}
}
}
}

2>
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse
response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
String username = request.getParameter("username");
String password = request.getParameter("password");
try {
// Load the JDBC driver
Class.forName("com.mysql.cj.jdbc.Driver");
// Set up the connection
Connection conn =
DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase",
"root", "password");// Prepare the statement
PreparedStatement stmt = conn.prepareStatement("SELECT * FROM
users WHERE username=? AND password=?");
stmt.setString(1, username);
stmt.setString(2, password);
// Execute the query
ResultSet rs = stmt.executeQuery();
// Check if the user exists
if (rs.next()) {
out.println("<h1>Login successful!</h1>");
} else {
out.println("<h1>Error: Invalid username or password.</h1>");
}
// Close the resources
rs.close();
stmt.close();
conn.close();
} catch (ClassNotFoundException | SQLException e) {
e.printStackTrace();
}
}
}
