slip-29
1>
import java.sql.*;public class DonarTableColumnInfo {
public static void main(String[] args) {
String url = "jdbc:mysql://localhost:3306/mydb"; // replace mydb with your
database name
String username = "root"; // replace root with your MySQL username
String password = "password"; // replace password with your MySQL
password
try (Connection con = DriverManager.getConnection(url, username,
password)) {
String query = "SELECT * FROM DONAR";
PreparedStatement ps = con.prepareStatement(query);
ResultSet rs = ps.executeQuery();
ResultSetMetaData rsmd = rs.getMetaData();
int columnCount = rsmd.getColumnCount();
System.out.println("Column Name\t\tData Type");
System.out.println("------------------------------------------");
for (int i = 1; i <= columnCount; i++) {
String columnName = rsmd.getColumnName(i);
String dataType = rsmd.getColumnTypeName(i);
System.out.println(columnName + "\t\t\t" + dataType);
}
} catch (SQLException e) {
System.out.println("Error: " + e.getMessage());}
}
}

2>
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        // Create a LinkedList of integers
        LinkedList<Integer> list = new LinkedList<>();

        // Add element at the first position
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        // Print the LinkedList after adding elements at first position
        System.out.println("LinkedList after adding elements at first position: " + list);

        // Delete the last element
        list.removeLast();

        // Print the LinkedList after deleting last element
        System.out.println("LinkedList after deleting last element: " + list);

        // Display the size of LinkedList
        System.out.println("Size of LinkedList: " + list.size());
    }
}

