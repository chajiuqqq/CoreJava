package JframeTest;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
/**
 * ��ϰ-���һ�������ļ��±����� 
 * @author Alice
 * @version 2019��8��6��
 */
public class MenuTest {
	public static void main(String[] args) {
		JFrame f=new JFrame("���±�");
		f.setLocation(200, 200);
		f.setSize(400, 300);
		/**
		 * ��Ӳ˵���
		 */
		JMenuBar menuBar=new JMenuBar();
		
		JMenu file=new JMenu("�ļ�(F)");
		JMenu edit=new JMenu("�༭(E)");
		JMenu format=new JMenu("��ʽ(O)");
		JMenu watch=new JMenu("�鿴(V)");
		JMenu help=new JMenu("����(H)");
		
		file.add(new JMenuItem("�½�"));
		file.add(new JMenuItem("��"));
		file.add(new JMenuItem("����"));
		file.add(new JMenuItem("���Ϊ"));
		file.add(new JMenuItem("�½�"));
		file.addSeparator();
		file.add(new JMenuItem("ҳ������"));
		file.add(new JMenuItem("��ӡ"));
		file.addSeparator();
		file.add(new JMenuItem("�˳�"));
		
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(format);
		menuBar.add(watch);
		menuBar.add(help);
		/**
		 * ��ӹ�����
		 */
		JToolBar toolBar=new JToolBar();
		JButton b1=new JButton("1");
		JButton b2=new JButton("2");
		JButton b3=new JButton("3");
		JButton b4=new JButton("4");
		JButton b5=new JButton("5");
		b1.setToolTipText("1");		// ����ť������ʾ��Ϣ
		toolBar.add(b1);
		toolBar.add(b2);
		toolBar.add(b3);
		toolBar.add(b4);
		toolBar.add(b5);
		
		toolBar.setFloatable(false);		 // ��ֹ�������϶�
		f.setLayout(new BorderLayout());	// �ѹ���������north��λ��
		f.add(toolBar,BorderLayout.NORTH);
		
		f.setJMenuBar(menuBar);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
