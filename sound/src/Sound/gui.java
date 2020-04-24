package Sound;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gui{
	JButton labelbutton;
	JButton colorbutton;
	JFrame frame;
	JLabel label;
	
	public static void main (String[] args) {
		gui agui = new gui();
		agui.go();
		


	}
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		colorbutton = new JButton("color click me");
		colorbutton.addActionListener(new LabelListener());
		labelbutton = new JButton("label click me");
		labelbutton.addActionListener(new ColorListener());
		
		label = new JLabel("a label");
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.getContentPane().add(BorderLayout.SOUTH, colorbutton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);		
		frame.getContentPane().add(BorderLayout.EAST, labelbutton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	
	class LabelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			label.setText("ouch");
		}
	}
	class ColorListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			label.setText("puch");
		}
	}
}


class MyDrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
		
	}
}
