slip-17
1>
package Assignment1;
import java.util.*;
import java.io.*;

public class setBa {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set s = new TreeSet();
		
		System.out.print("Enter no.of integers:");
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			System.out.print("Enter number:");
			int x = Integer.parseInt(br.readLine());
			s.add(x);
	    }
		Iterator itr = s.iterator();
		while (itr.hasNext()) {
		System.out.println(itr.next());
		}
	
	}
}

2>
package TYBCS;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class NumberDisplay implements Runnable {
private JTextField textField;
public NumberDisplay(JTextField textField) {
this.textField = textField;
}
@Override
public void run() {
for (int i = 1; i <= 100; i++) {textField.setText(Integer.toString(i));
try {
Thread.sleep(100);
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
public static void main(String[] args) {
JFrame frame = new JFrame("Number Display");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JTextField textField = new JTextField(10);
JButton button = new JButton("Start");
JPanel panel = new JPanel();
panel.add(textField);
panel.add(button);
frame.add(panel, BorderLayout.CENTER);
frame.pack();
frame.setVisible(true);
button.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
NumberDisplay numberDisplay = new NumberDisplay(textField);
Thread thread = new Thread(numberDisplay);
thread.start();}
});
}
}
