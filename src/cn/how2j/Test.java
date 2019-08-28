package cn.how2j;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
public class Test {
	
	public static void main(String[] args) {
		 JFrame f = new JFrame();
	        f.setSize(500, 500);
	        f.setLocationRelativeTo(null);
	        f.setLayout(new BorderLayout());
	        MyPanel p=new MyPanel();
	        JButton button=new JButton("add");
	        f.add(p,BorderLayout.CENTER);
	        f.add(button,BorderLayout.NORTH);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setVisible(true);
	        
	}
	static class MyPanel extends JPanel{
		JLabel l=new JLabel("add");
		JTextField tf=new JTextField();
		JButton b=new JButton("submit");
		
		public MyPanel() {
			this.setLayout(new GridLayout(2,2));
			tf.setPreferredSize(new Dimension(100, 30));
			this.add(l);
			this.add(tf);
			this.add(b);
		}
	}
	
	
}
