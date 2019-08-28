package JframeTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * ���JFrame�����°�ť���һ��JDialogģ̬����
 * ����һ��button�����º�JDialog���ɸı��С���ٰ��¿��Ըı��С
 * @author Alice
 * @version 2019��8��4��
 */
public class JDialogTest {
	public static void main(String[] args) {
		JFrame f=new JFrame("������");
		f.setLayout(null);
		f.setSize(800,600);
		f.setLocation(100, 100);
		
		JButton b1=new JButton("���´���");
		b1.setBounds(300, 300, 300, 30);
		f.add(b1);
		
		JDialog dia=new JDialog(f,"ģ̬");
		dia.setModal(true);
		dia.setBounds(300, 300, 400, 300);
		dia.setLayout(null);
		
		JButton b2=new JButton("�ɱ�");
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
					b2.setText("�̶�");
				}else{
					dia.setResizable(true);
					b2.setText("�ɱ�");
				}
			}
		});
	}
}
