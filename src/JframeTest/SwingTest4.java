package JframeTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * ��ϰ-�ƺ� 
 * @author Alice
 * @version 2019��8��5��
 */
public class SwingTest4 {
	/**
	 * �ж��Ƿ�Ϊ�Ϸ���������
	 * @param str
	 * @return
	 */
	public static boolean judge(String str) {
		for(char x:str.toCharArray()){
			if(x>'9'||x<'0')
				if(x=='.')
					continue;
				else return false;
		}
		return true;
	}
	public static void main(String[] args) {
		JFrame f=new JFrame("test4");
		f.setLocation(200, 200);
		f.setSize(500, 350);
		f.setLayout(null);
		
		JLabel L1=new JLabel("����:");
		JLabel L2=new JLabel("��˾����:");
		JLabel L3=new JLabel("��˾����:");
		JLabel L4=new JLabel("�ϰ�����:");
		JLabel L5=new JLabel("���:");
		JLabel L6=new JLabel("��Ʒ:");
		JLabel L7=new JLabel("�۸������λ:");
		
		JTextField t1=new JTextField("�㽭����");
		JTextField t2=new JTextField("Ƥ�ﳧ");
		JTextField t3=new JTextField("����Ƥ�ﳧ");
		JTextField t4=new JTextField("�ƺ�");
		JTextField t5=new JTextField("3.5");
		JTextField t6=new JTextField("Ǯ��");
		JTextField t7=new JTextField("��");
		
		JButton button=new JButton("����");
		
		JTextArea area=new JTextArea();
		area.setLineWrap(true);
		
		L1.setBounds(10, 5, 100, 20);
		t1.setBounds(105, 5, 100, 20);
		L2.setBounds(250, 5, 100, 20);
		t2.setBounds(350, 5, 100, 20);
		
		L3.setBounds(10, 35, 100, 20);
		t3.setBounds(105, 35, 100, 20);
		L4.setBounds(250, 35, 100, 20);
		t4.setBounds(350, 35, 100, 20);
		
		L5.setBounds(10, 65, 100, 20);
		t5.setBounds(105, 65, 100, 20);
		L6.setBounds(250, 65, 100, 20);
		t6.setBounds(350, 65, 100, 20);
		
		L7.setBounds(10, 95, 100, 20);
		t7.setBounds(105, 95, 100, 20);
		
		button.setBounds(150,130, 150, 30);
		
		area.setBounds(10,170, 460, 100);
		
		f.add(area);
		f.add(button);
		f.add(t7);
		f.add(t6);
		f.add(t5);
		f.add(t4);
		f.add(t3);
		f.add(t2);
		f.add(t1);
		
		f.add(L1);
		f.add(L2);
		f.add(L3);
		f.add(L4);
		f.add(L5);
		f.add(L6);
		f.add(L7);
		
	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		/**
		 * ��button��Ӽ�����
		 */
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/**
				 * ��ȡ��������
				 */
				String[] s={" ",
						t1.getText()
						,t2.getText()
						,t3.getText()
						,t4.getText()
						,t5.getText()
						,t6.getText()
						,t7.getText()
						};
				/**
				 * ��ֵ���
				 */
				for(String x:s){
					if("".equals(x)){
						JOptionPane.showMessageDialog(f, "�����п�ֵ��");
						return; 
					}
				}
				/**
				 * ���ּ��
				 */
				if(!judge(s[5])){
					JOptionPane.showMessageDialog(f, "�����������ȷ�����֣�");
					return; 
				}
					
				/**
				 * ����
				 */
				String all=String.format("%s���%s%s�����ˣ�"
						+ "���˵��ϰ�%s�Ժ��ζģ�Ƿ����%s���ڣ���������С��������!"
						+ "����û�а취������%s�ֹ���!ԭ�۶���һ%s�ࡢ��%s�ࡢ��%s���Ǯ����"
						+ "����ȫ��ֻ����ʮ�飬ͳͳֻҪ��ʮ��!%s���˵����㲻����!"
						+ "����������������˴���꣬�㲻�����ʣ�"
						+ "�㻹��Ѫ��Ǯ������Ѫ��Ǯ!", s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[7],s[7],s[4]);
				area.setText(all);
			}
		});
	
		
			
	}
}
