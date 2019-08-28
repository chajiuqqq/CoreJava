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
 * ��ϰ-Ϊ���ж�
 * @author Alice
 * @version 2019��8��5��
 */
public class SwingTest1 {
	public static void main(String[] args) {
		JFrame f=new JFrame("test1");
		f.setLocation(50, 50);
		f.setSize(400, 300);
		f.setLayout(new FlowLayout());
		
		
		JTextField field=new JTextField();
		JButton button=new JButton("���");
		
		//ʹ����FlowLayout���֣��������ı������С��ʹ��setPreferredSize����
		//����new Dimension(��,��)
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
					JOptionPane.showMessageDialog(f, "�ı����ݲ���Ϊ��");
				}else{
					JOptionPane.showMessageDialog(f, "�����������Ϊ"+str);
				}
			}
		});
		
			
	}
}
