package JframeTest;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 * 练习-为空判断
 * @author Alice
 * @version 2019年8月5日
 */
public class SwingTest1 {
	public static void main(String[] args) {
		JFrame f=new JFrame("test1");
		f.setLocation(50, 50);
		f.setSize(400, 300);
		f.setLayout(new FlowLayout());
		
		
		JTextField field=new JTextField();
		JButton button=new JButton("检测");
		
		//使用了FlowLayout布局，如果还想改变组件大小，使用setPreferredSize方法
		//传入new Dimension(长,宽)
		field.setPreferredSize(new Dimension(80,30));
		f.add(field);
		f.add(button);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str=field.getText();
				if(str.equals("")){
					JOptionPane.showMessageDialog(f, "文本内容不能为空");
				}else{
					JOptionPane.showMessageDialog(f, "你输入的内容为"+str);
				}
			}
		});
		
			
	}
}
