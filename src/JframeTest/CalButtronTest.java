package JframeTest;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * ����4*5�ļ�������ť����
 * ���ֲ��ַ�ʽ
 * FlowLayout()����ʽ���֣������ϵ����ˮƽ�ڷ�
 * 			f.setLayout(new FlowLayout());
 * BorderLayout()���߽粼�֣������ϵ���������ϱ����������Ҷ��е�˳��ڷ�	
 * 			f.setLayout(new BorderLayout());
 * 			���뵽������ʱ����Ҫָ��λ��
	        f.add(b1, BorderLayout.NORTH);
	        f.add(b2, BorderLayout.SOUTH);
 * GridLayout�����񲼾�������GridLayerout�Ĺ��췽����ʾ��������2��3��
        	f.setLayout(new GridLayout(2, 3));
 * @author Alice
 * @version 2019��8��4��
 *
 */
public class CalButtronTest {
	public static void main(String[] args) {
		JFrame f=new JFrame("cal");
		f.setSize(400,300);
		f.setLocation(100,100);
		f.setLayout(new GridLayout(4, 5));
		 String[] strs= {"7","8","9","/","sq","4","5","6","*","%","1","2","3","-","1/x","0","+/-",".","+","="};
	        for(String str:strs) {
	            JButton button=new JButton(str);
	            f.add(button);
	        }
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
