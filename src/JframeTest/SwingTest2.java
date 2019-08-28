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
 * 练习-数字校验
 * @author Alice
 * @version 2019年8月5日
 */
public class SwingTest2 {
	public static boolean judge(String str) {
		for(char x:str.toCharArray()){
			if(x>'9'||x<'0')
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		JFrame f=new JFrame("test2");
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
				if(!judge(str)){
					JOptionPane.showMessageDialog(f, "请输入数字");
				}else{
					JOptionPane.showMessageDialog(f, "你输入的数字为"+str);
				}
			}
		});
		
			
	}
}
