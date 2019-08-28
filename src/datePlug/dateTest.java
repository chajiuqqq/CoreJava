package datePlug;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jdesktop.swingx.JXDatePicker;
/**
 * 一个日期控件，一个button，按下会弹出当前日期的窗口
 * @author Alice
 * @version 2019年8月8日
 */
public class dateTest {
	public static void main(String[] args) {
		JFrame f=new JFrame("date");
		f.setLocation(300,200);
		f.setSize(400, 300);
		
		
		JXDatePicker picker=new JXDatePicker();
		picker.setDate(new Date());
		picker.setPreferredSize(new Dimension(200,30));
		JButton button=new JButton("获取日期");
		
	
		f.add(picker);
		f.add(button);
		f.setLayout(new FlowLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date date=picker.getDate();
				JOptionPane.showMessageDialog(f, "当前日期为："+date);
			}
		});
	}
}
