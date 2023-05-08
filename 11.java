slip-11
1>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Search</title>
</head>
<body>
    <h1>Customer Search</h1>
    <form action="search" method="post">
        <label for="customerNumber">Customer Number:</label>
        <input type="text" name="customerNumber" id="customerNumber">
        <button type="submit">Search</button>
    </form>
</body>
</html>
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CustomerSearchServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the customer number from the request parameter
        String customerNumber = request.getParameter("customerNumber");
        
        // Search for the customer in the database
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password")) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer WHERE customerNumber = ?");
            stmt.setString(1, customerNumber);
            ResultSet rs = stmt.executeQuery();
            
            // If the customer is found, display the customer details
            if (rs.next()) {
                String customerName = rs.getString("customerName");
                String contactLastName = rs.getString("contactLastName");
                String contactFirstName = rs.getString("contactFirstName");
                String phone = rs.getString("phone");
                String addressLine1 = rs.getString("addressLine1");
                String addressLine2 = rs.getString("addressLine2");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String postalCode = rs.getString("postalCode");
                String country = rs.getString("country");
                double creditLimit = rs.getDouble("creditLimit");
                
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Customer Details</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Customer Details</h1>");
                out.println("<p>Customer Number: " + customerNumber + "</p>");
                out.println("<p>Customer Name: " + customerName + "</p>");
                out.println("<p>Contact Name: " + contactLastName + ", " + contactFirstName + "</p>");
                out.println("<p>Phone: " + phone + "</p>");
                out.println("<p>Address: " + addressLine1 + "<br>" + addressLine2 + "<br>" + city + ", " + state + " " + postalCode + "<br>" + country + "</p>");
                out.println("<p>Credit Limit: " + creditLimit + "</p>");
                out.println("</body>");
                out.println("</html>");
            } else {
                // If the customer is not found, display an error message
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Error</h1>");
                out.println("<p>Customer not found.</p>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}

2>
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ass3A3 {

	public static void main(String[] args) {
		try
        {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver is loaded");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","tybcs","tybcs123"); 
            if(conn==null)
           	 System.out.println("connection not established");
           
            else 
            {
            	Statement st=conn.createStatement();
	              ResultSet  rs=st.executeQuery("select * from Donar"); 
	              ResultSetMetaData rsmd=rs.getMetaData();
	              int cols=rsmd.getColumnCount();
	              System.out.println("Total number of columns in Donar:"+cols);
	              for(int i=1;i<=cols;i++)
	              {
	            	  System.out.println("Column Number:"+i);
	            	  System.out.println("Column Name:"+rsmd.getColumnName(i));
	            	  System.out.println("Column Type:"+rsmd.getColumnTypeName(i));
	            	  System.out.println("Column Display Size:"+rsmd.getColumnDisplaySize(i));
	            	  Boolean a=rsmd.isWritable(i);
	            	  if(a==true)
	            	  System.out.println("column is Writable");
	            	  else
	            		  System.out.println("column is not Writable");  
	            	  
	              }
            }
        }
        catch(Exception e)
        {
          System.out.println("Error"+e.getMessage());     
        }
		
		// TODO Auto-generated method stub

	}

}

