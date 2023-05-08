slip-26
1>
import java.sql.*;
public class DeleteEmployeeDetails {
public static void main(String[] args) {
try {
// Step 1: Load the JDBC driver
Class.forName("com.mysql.jdbc.Driver");
// Step 2: Establish the connection to the database
String url = "jdbc:mysql://localhost:3306/yourdatabase";
String username = "yourusername";
String password = "yourpassword";
Connection con = DriverManager.getConnection(url, username,
password);
// Step 3: Create a prepared statement to delete the employee details
PreparedStatement pstmt = con.prepareStatement("DELETE FROM
Employee WHERE ENo=?");// Step 4: Set the employee ID parameter for the prepared statement
int employeeID = Integer.parseInt(args[0]);
pstmt.setInt(1, employeeID);
// Step 5: Execute the prepared statement
int rowsAffected = pstmt.executeUpdate();
System.out.println(rowsAffected + " row(s) deleted.");
// Step 6: Close the resources
pstmt.close();
con.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}

2>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Sum of First and Last Digit</title>
</head>
<body>
<h1>Calculate Sum of First and Last Digit</h1>
<%
// Retrieve the number from the request parameter
int num = Integer.parseInt(request.getParameter("number"));
// Extract the first and last digit of the number
int firstDigit = num;
while (firstDigit >= 10) {
    firstDigit /= 10;
}
int lastDigit = num % 10;
// Calculate the sum of first and last digit
int sum = firstDigit + lastDigit;
// Display the sum in red color with font size 18
out.println("<p style=\"color:red;font-size:18px;\">Sum of first and last digit of " + num + " is " + sum + "</p>");
%>
<form action="" method="get">
<label for="number">Enter a number:</label>
<input type="number" id="number" name="number" required>
<button type="submit">Calculate</button>
</form>
</body>
</html>

