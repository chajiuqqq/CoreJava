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
 * һ�����ڿؼ���һ��button�����»ᵯ����ǰ���ڵĴ���
 * @author Alice
 * @version 2019��8��8��
 */
public class dateTest {
	public static void main(String[] args) {
		JFrame f=new JFrame("date");
		f.setLocation(300,200);
		f.setSize(400, 300);
		
		
		JXDatePicker picker=new JXDatePicker();
		picker.setDate(new Date());
		picker.setPreferredSize(new Dimension(200,30));
		JButton button=new JButton("��ȡ����");
		
	
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
				JOptionPane.showMessageDialog(f, "��ǰ����Ϊ��"+date);
			}
		});
	}
}
