slip-30
1>
class Counter {
private int count = 0;
// synchronized method
public synchronized void increment() {
count++;
}
public int getCount() {
return count;
}
}
class MyThread extends Thread {
private Counter counter;
public MyThread(Counter counter) {
this.counter = counter;
}
public void run() {
for (int i = 0; i < 1000; i++) {
counter.increment();
}}
}
public class SyncDemo {
public static void main(String[] args) throws InterruptedException {
Counter counter = new Counter();
MyThread thread1 = new MyThread(counter);
MyThread thread2 = new MyThread(counter);
thread1.start();
thread2.start();
thread1.join();
thread2.join();
System.out.println("Count: " + counter.getCount());
}
}

2>
import java.sql.*;
public class ScrollableResultSetExample {
public static void main(String[] args) {try {
// Register JDBC driver
Class.forName("com.mysql.jdbc.Driver");
// Open a connection
Connection conn =
DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
"username", "password");
// Create a Statement object with scrollable ResultSet
Statement stmt =
conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
ResultSet.CONCUR_READ_ONLY);
// Execute a query and get the ResultSet object
ResultSet rs = stmt.executeQuery("SELECT * FROM Teacher");
// Move the cursor to the last row
rs.last();
// Get the total number of rows in the ResultSet
int rowCount = rs.getRow();
// Move the cursor back to the first row
rs.beforeFirst();
// Display the column headersResultSetMetaData rsmd = rs.getMetaData();
for (int i = 1; i <= rsmd.getColumnCount(); i++) {
System.out.print(rsmd.getColumnName(i) + "\t");
}
System.out.println();
// Iterate through the ResultSet and display the data
while (rs.next()) {
System.out.print(rs.getInt("TID") + "\t");
System.out.print(rs.getString("TName") + "\t");
System.out.print(rs.getInt("Salary") + "\t");
System.out.println();
}
// Close the ResultSet, Statement, and Connection
rs.close();
stmt.close();
conn.close();
} catch (Exception ex) {
ex.printStackTrace();
}
}
}
