	*********slip no 8 ********


import java.util.*;
import java.io.*;

class setA1 extends Thread
{
  String msg;
  int n;
  setA1(String msg,int n)
  {
     this.msg=msg;
     this.n=n;
     }
    public  void run()
     {
     try{
    
     for(int i=0;i<n;i++)
     {
          System.out.println(msg+" "+(i+1)+"times");
          Thread.sleep(600);
     }
      
     }
     catch(Exception e)
     {
     }
}
}

 public class setAa
{
public static void main(String args[])
{
   int n1=Integer.parseInt(args[0]);
   setA1 t1=new setA1("COVID19",n1);
   t1.start();

   setA1 t2=new setA1("LOCKDOWN2020",n1+10);
   t2.start();

   setA1 t3 =new setA1("VACCINATED2021",n1+20);
   t3.start();
    
   }
   }
   
2>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prime Checker</title>
</head>
<body>
    <%
        int num = Integer.parseInt(request.getParameter("num"));
        boolean isPrime = true;
        
        // Check if number is prime
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        
        // Display result in red color
        if (isPrime) {
    %>
            <h2 style="color:red"><%= num %> is a prime number</h2>
    <%
        } else {
    %>
            <h2 style="color:red"><%= num %> is not a prime number</h2>
    <%
        }
    %>
</body>
</html>
   
