slip-12
1>
index.html

<!DOCTYPE html>
<html>
<head>
<title>PERFECT NUMBER</title>
</head>
<body>
<form action="perfect.jsp" method="post">
Enter Number: <input type="text" name="num">
<input type="submit" value="Submit" name="s1">
</form>
</body>
</html>

perfect.jsp

<%@ page import="java.util.*" %>
<%
if(request.getParameter("s1") != null) {
    int num = 0, sum = 0;
    try {
        num = Integer.parseInt(request.getParameter("num"));
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if (sum == num) {
            out.println(num + " is a perfect number");
        } else {
            out.println(num + " is not a perfect number");
        }
    } catch (NumberFormatException e) {
        out.println("Invalid input");
    }
}
%>

2>
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.table.*;
import java.util.Vector;
public class Ass3a1 extends JFrame implements ActionListener {
	
		   
		
			JFrame f=new JFrame();
			JPanel p=new JPanel();
			JTextField jt1=new JTextField(10);
			JTextField jt2=new JTextField(10);
			JTextField jt3=new JTextField(10);
			JTextField jt4=new JTextField(10);
			JButton insert,disp,reset;
			 int row,column;
			Ass3a1()
			{	
				
		        f.setSize(300,300);
		           
		      
			f.setTitle("Project Details");
			f.setLayout(new FlowLayout());
					f.setVisible(true);
					  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			GridLayout g=new GridLayout(4,1,10,10);
			p.setLayout(g);
			JLabel l1=new JLabel("Project ID");
			JLabel l2=new JLabel("Project Name");
			JLabel l3=new JLabel("Project Description");
			JLabel l4=new JLabel("Project Status");
			p.add(l1);
			p.add(jt1);
			p.add(l2);p.add(jt2);
			p.add(l3);p.add(jt3);
			p.add(l4);p.add(jt4);
			f.add(p);
			insert=new JButton("Insert");
			f.add(insert);
			 insert.addActionListener(this);
			
			disp=new JButton("Display");
			f.add(disp);
			
			disp.addActionListener(this);
			reset=new JButton("Reset");
			f.add(reset);
			reset.addActionListener(this);
			try
	        {
	            Class.forName("org.postgresql.Driver");
	            System.out.println("Driver is loaded");
	        }
	        catch(Exception e)
	        {
	          System.out.println("Error"+e.getMessage());     
	        }
	}
			public void actionPerformed(ActionEvent e2) 
			{
				if(e2.getSource()==reset)
				{
					jt1.setText("");
					jt2.setText("");
					jt3.setText("");
					jt4.setText("");
				}
				if(e2.getSource()==insert)
		        {
		            try
		           {
		               int pno=Integer.parseInt(jt1.getText());
		               String pname=jt2.getText();
		               String pdescr=jt3.getText();
		               String pstatus=jt4.getText();
		               
		                
		      Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","tybcs","tybcs123"); 
		                 if(conn==null)
		                	 System.out.println("connection not established");
		                 else {
		                PreparedStatement st=conn.prepareStatement("insert into project values(?,?,?,?)");
		                st.setInt(1,pno);
		                st.setString(2,pname);
		                st.setString(3,pdescr);
		                st.setString(4,pstatus);
		                st.executeUpdate(); 
		                st.close();
		                JOptionPane.showMessageDialog(this,"Inserted");
		                     
		           }}catch(Exception e)
		           {
		               System.out.println("Error"+e.getMessage());
		           }
		        }  
		        if(e2.getSource()==disp)
		        {
		            try
		           {
		                String col[]= {"P_ID","P_Name","P_Desc","P_Status"};
		             
		        
		             
		               Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","tybcs","tybcs123"); 
		                Statement st=conn.createStatement();
		              
		               ResultSet rs=st.executeQuery("select * from project");
		              //  System.out.println("Project ID"+"\t"+"Project Name"+"\t"+"Project Description"+"\t"+"Project Status");
	                     // while(rs.next()) 
	                    //  {
	                    //	  System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
	                     // }
	             
		              
		               JFrame f1=new JFrame("Table Content");
		               f1.setLayout(new BorderLayout());
		               f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		               DefaultTableModel t1=new DefaultTableModel();
		               
		               t1.setColumnIdentifiers(col);
		               JTable tbl=new JTable();
		               tbl.setModel(t1);
		               tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		               tbl.setFillsViewportHeight(true);
		               JScrollPane scrl=new JScrollPane(tbl);
		            //   scrl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		             //  scrl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		      
		              while(rs.next())
	                      {
		            
	                    	  String pno=rs.getString(1);
	                    			  String PName=rs.getString(2);
	                    			  String PDescr=rs.getString(3);
	                    			  String PStatus=rs.getString(4);
	                    	
	                    			  t1.addRow(new Object []{pno,PName,PDescr,PStatus});
	                    			
	                      }f1.add(scrl);
	                      f1.setSize(300,300);
	                      f1.setVisible(true);
		               rs.close();
		              
		           }catch(Exception e)
		           {
		                
		           }
		        }
		        
		        
		    }
				
			

			
	public static void main(String[] args) {
		Ass3a1 ob=new Ass3a1();



	

	}



	



	

}

