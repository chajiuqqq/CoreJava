package JframeTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * 设计JFrame，按下按钮后打开一个JDialog模态窗口
 * 其中一个button，按下后JDialog不可改变大小，再按下可以改变大小
 * @author Alice
 * @version 2019年8月4日
 */
public class JDialogTest {
	public static void main(String[] args) {
		JFrame f=new JFrame("主窗口");
		f.setLayout(null);
		f.setSize(800,600);
		f.setLocation(100, 100);
		
		JButton b1=new JButton("打开新窗口");
		b1.setBounds(300, 300, 300, 30);
		f.add(b1);
		
		JDialog dia=new JDialog(f,"模态");
		dia.setModal(true);
		dia.setBounds(300, 300, 400, 300);
		dia.setLayout(null);
		
		JButton b2=new JButton("可变");
		b2.setBounds(150, 150, 100, 30);
		dia.add(b2);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		dia.setVisible(false);
		
		
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					if(dia.isShowing()){
						dia.setVisible(false);
					}else
						dia.setVisible(true);
			}
		});
		b2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(dia.isResizable()){
					dia.setResizable(false);
					b2.setText("固定");
				}else{
					dia.setResizable(true);
					b2.setText("可变");
				}
			}
		});
	}
}
