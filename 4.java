	********* Runnable Interface **********
	
	
	
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlinkingText implements Runnable {

    private JLabel label;
    private boolean isBlinking = true;

    public BlinkingText(JLabel label) {
        this.label = label;
    }

    public void run() {
        while (isBlinking) {
            try {
                label.setVisible(!label.isVisible());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopBlinking() {
        isBlinking = false;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Blinking Text Example");
        JLabel label = new JLabel("Blinking Text!");
        frame.getContentPane().add(label);
        frame.setSize(300, 100);
        frame.setVisible(true);
        BlinkingText blinkingText = new BlinkingText(label);
        Thread t = new Thread(blinkingText);
        t.start();

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                blinkingText.stopBlinking();
                System.exit(0);
            }
        });
    }
}


	********* city name & their STD codes ********



package ty;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

public class setCa extends JFrame implements ActionListener{
	JTextField jt1= new JTextField(20);
	JTextField jt2=new JTextField(16);
	final JFrame frame=new JFrame("OptionPanDemo");
	HashMap hm=new HashMap();
	int massageType=-1;
	String massage="";
	public setCa(){
		Container  con=getContentPane();
		con.setLayout(new FlowLayout());
		JLabel j1=new JLabel("City");
		con.add(j1);
		con.add(jt1);
		jt1.addActionListener(this);
		JLabel j2=new JLabel("STD Code");
		con.add(j2);
		con.add(jt2);
		JButton jb1=new JButton("ADD");
		jb1.setBounds(50,100,90,20);
		jb1.addActionListener(this);
		con.add(jb1);
		JButton jb2=new JButton("Remove");
		jb2.setBounds(50,100,90,20);
		jb2.addActionListener(this);
		con.add(jb2);
		JButton jb3=new JButton("Search");
		jb3.setBounds(50,100,90,20);
		jb3.addActionListener(this);
		con.add(jb3);
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String args[]) {
		new setCa(); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String op=e.getActionCommand();
		if(op.equals("ADD"))
		{
			String city=jt1.getText();
			String std=jt2.getText();
			if(city.length()==0)
			{
				massageType=JOptionPane.WARNING_MESSAGE;
				massage="Please enter city";
				JOptionPane.showMessageDialog(frame,massage,"Massag",massageType);
			}
			if(std.length()==0)
			{
				massageType=JOptionPane.WARNING_MESSAGE;
				massage="please enter std";
				JOptionPane.showMessageDialog(frame,massage,"Massag",massageType);
			}
			else {
			hm.put(city, std);
			massageType=JOptionPane.INFORMATION_MESSAGE;
			massage="Information Updated";
			JOptionPane.showMessageDialog(frame,massage,"Massag",massageType);
			}
		}
		if(op.equals("Remove"))
		{
			String city=jt1.getText();
			String std=jt2.getText();
			if(city.length()==0)
			{
				massageType=JOptionPane.WARNING_MESSAGE;
				massage="please enter city";
				JOptionPane.showMessageDialog(frame,massage,"Massag",massageType);
				
			}
			else {
			hm.remove(city);
			massageType=JOptionPane.ERROR_MESSAGE;
			massage="City Removed";
			JOptionPane.showMessageDialog(frame,massage,"Massag",massageType);
			}
			
		}
		if(op.equals("Search"))
		{
		String city=jt1.getText();
		if(city.length()==0)
		{
			massageType=JOptionPane.WARNING_MESSAGE;
			massage="please enter city";
			JOptionPane.showMessageDialog(frame,massage,"Massag",massageType);
		}
		else
		jt2.setText((String)hm.get(city));
		}
	}
}



