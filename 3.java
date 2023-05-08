	******* JSP display patient detail *********
	
	
	
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Patient Details</title>
</head>
<body>
    <h1>Patient Details</h1>
    <table border="1">
        <tr>
            <th>Patient No</th>
            <th>Patient Name</th>
            <th>Patient Address</th>
            <th>Patient Age</th>
            <th>Patient Disease</th>
        </tr>
        <%
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "ram", "ram123");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Hospital");
                while (rs.next()) {
                    int patientNo = rs.getInt("PatientNo");
                    String patientName = rs.getString("PatientName");
                    String patientAddress = rs.getString("PatientAddress");
                    int patientAge = rs.getInt("PatientAge");
                    String patientDisease = rs.getString("PatientDisease");
        %>
                    <tr>
                        <td><%= patientNo %></td>
                        <td><%= patientName %></td>
                        <td><%= patientAddress %></td>
                        <td><%= patientAge %></td>
                        <td><%= patientDisease %></td>
                    </tr>
        <%
                }
                con.close();
            } catch (Exception e) {
                out.println(e);
            }
        %>
    </table>
</body>
</html>


	********* create linkedlist *********



import java.util.*;
public class setCb {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		int q=0,ch;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.print("\n1.add element at first position\n2.delete last element\n3.Size of link list\n4.exit\nChoice:");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.print("Enter Element:");
				String element=sc.next();
				l.add(element);
				System.out.println("Link List:"+l);
				break;
			case 2:
				l.removeLast();
				System.out.println("Link List"+l);
				break;
			case 3:
				System.out.println("Link List:"+l+"\nSize Of Link List:"+l.size());
				break;
			case 4:
				q=1;
				break;
			}
		}while(q!=1);

	}

}

