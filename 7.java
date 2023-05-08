	****** Implements multithread application *********
	
	
package ty;
import java.lang.Thread;
import java.util.Random;
class SquareCube extends Thread
{
 public void run()
 {
  Random r=new Random();
  for(int i=0;i<5;i++)
  {
     int n=r.nextInt(100);
     System.out.println("Random integer genrated is="+n);
     if(n%2==0)
     {
       Square s=new Square(n);
       s.start();
       try
       {
       Thread.sleep(1000);
       }catch(Exception e){}
     }
     else
     {
   Cube c=new Cube(n);
       c.start();
       try
       {
       Thread.sleep(1000);
       }catch(Exception e){}
   }
   }
   
 }  
}
class Square extends Thread
{
int x;
Square(int n1)
{
  x=n1;
  }
  public void run()
  {
    System.out.println("Square is ="+(x*x));
    }
    }
    
   class Cube extends Thread
{
int x;
Cube(int n1)
{
  x=n1;
  }
  public void run()
  {
    System.out.println("cube is ="+(x*x*x));
    }
    } 
    class Exer2B3
    {
     public static void main(String args[]) throws InterruptedException
     
     {
        SquareCube sc=new SquareCube();
        sc.start();
        }
        }
   


	********* create product *******



package TYBCS;
import java.sql.*;
public class slip7
{
public static void main(String args[])
{
String id = "id1";
String pwd = "pwd1";
String fullname = "geeks for geeks";
String email = "geeks@geeks.org";
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "login","login123");
Statement stmt = con.createStatement();// Inserting data in database
String q1 = "insert into userid values('" +id+ "','" +pwd+"', '" +fullname+ "','" +email+ "')";
int x = stmt.executeUpdate(q1);
if (x > 0)
System.out.println("Successfully Inserted");
else
System.out.println("Insert Failed");
con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}
    
    
    
    
    
    
    
    
    
    
    
    
    

