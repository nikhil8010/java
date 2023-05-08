		****** display alphabets A to Z ******


package TYBCS;
import java.util.*;
public class slip1_1 extends Thread
{
char c;
public void run()
{
for(c = 'A'; c<='Z';c++)
{
System.out.println(""+c);
try
{
Thread.sleep(3000);
}
catch(Exception e)
{
e.printStackTrace();
}
}
}
public static void main(String args[])
{
slip1_1 t = new slip1_1();
t.start();
}
}

	******** Employee details ******
	
	
	
	
package TYBCS;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class slip1_2   extends JFrame implements ActionListener{
	
	JFrame f=new JFrame();
	JPanel p=new JPanel();
	JLabel  l1,l2,l3,l4;
	JTextField t1=new JTextField(10);
	JTextField t2=new JTextField(10);
	JTextField t3=new JTextField(10);
	JTextField t4=new JTextField(10);
	JButton add,display; 
	slip1_2()
	{
	  f.setSize(300,300);
	  f.setTitle("Employee Data");
	  f.setLayout(new FlowLayout());
	  f.setVisible(true);
      GridLayout g=new GridLayout(4,1,10,10);
      p.setLayout(g);
      
     l1=new JLabel("Enter Employee Number :");
     l2=new JLabel("Enter Employee Name :");
     l3=new JLabel("Enter Employee Desination :");
     l4=new JLabel("Enter Employee Salary :");
     
     p.add(l1);
     p.add(t1);
     p.add(l2);p.add(t2);
     p.add(l3);p.add(t3);
     p.add(l4);p.add(t4);
     f.add(p);
     
     f.setVisible(true);
     
     add=new JButton("Insert");
     f.add(add);
     add.addActionListener(this);
     
     display=new JButton("Display");
     f.add(display);
    display.addActionListener(this);
     
  try
  {
     Class.forName("org.postgresql.Driver");
	 System.out.println("Driver Load");
	 
	}catch(Exception e)
    {
    System.out.println("Error");
    }
	}
  
	
	
	public void actionPerformed(ActionEvent e2)
	{
		if(e2.getSource()==add)
		{
		try {
			int eno=Integer.parseInt(t1.getText());
			String Ename=t2.getText();
			String des=t2.getText();
			
			int salary=Integer.parseInt(t4.getText());

			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/a","om1","om1");
            
			if(con==null)
				 System.out.println("Connection Faild");
			else
			{
		         PreparedStatement st=con.prepareStatement("insert into emp values(?,?,?,?)");
		         st.setInt(1,eno);
		         st.setString(2,Ename);
		         st.setString(3,des);
		         st.setInt(4,salary);
		        
		         st.executeUpdate();
		         st.close();
		        		 
		         JOptionPane.showMessageDialog(this,"inserted");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
		
	/*	if(e2.getSource()==display)
		{
			String col[]= {"Eno","Ename,","des","salary"};
			try {
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/a","ajays","ajay123");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("SELECT * FROM emp");
				
				JFrame f1=new JFrame("Tabel Content");
				f1.setLayout(new BorderLayout());
				DefaultTableModel t1=new DefaultTableModel();
				t1.setColumnIdentifiers(col);
				JTable tbl=new JTable();
				tbl.setModel(t1);
				 JScrollPane scrl=new JScrollPane(tbl);
				
				
				
				while(rs.next())
				{
					String eno=rs.getString(1);
					String ename=rs.getString(2);
					String des=rs.getString(3);
					String salary=rs.getString(4);
					
					t1.addRow(new Object[]{eno,ename,des,salary} );
				}
				f1.add(scrl);
				f1.setSize(300,300);
				f1.setVisible(true);
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} */
	}
	
	
	public static void main(String[] agrs)
	{
	slip1_2 o=new slip1_2();
	}

}

