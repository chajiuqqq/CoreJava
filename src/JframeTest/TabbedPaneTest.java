package JframeTest;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.io.File;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/**
 * �ο�eclipse�ķ�񣬽���TabbedPanel��ʾһ���������е�java�ļ�
 * @author Alice
 * @version 2019��8��5��
 */
public class TabbedPaneTest {

	public static void main(String[] args) {
		JFrame f=new JFrame("LoL");
		f.setLocation(20, 30);
		f.setSize(800, 600);
		f.setLayout(null);
		JTabbedPane tab=new JTabbedPane();
		
		File file=new File("E:\\project\\CoreJava\\src\\thread");
		File[] files=file.listFiles();
		int index=0;
		for(File x:files){
			JPanel panel=new JPanel();
			//panel.setBounds(0, 0, 780, 500);
			panel.setLayout(new BorderLayout());
			TextArea area=new TextArea();
			//area.setBounds(0, 0, 780, 500);
			
			char[] ch=null;
			try(FileReader freader=new FileReader(x);) {
				ch=new char[(int)x.length()];
				freader.read(ch);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			area.setText(String.valueOf(ch));
			
			
			
			panel.add(area);
			tab.add(panel);
			tab.setTitleAt(index, x.getName());
			ImageIcon icon=new ImageIcon("C:\\Users\\Alice\\Pictures\\pic.png");
			tab.setIconAt(index, icon);
			index++;
			
		}
		
		
		f.setContentPane(tab);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
