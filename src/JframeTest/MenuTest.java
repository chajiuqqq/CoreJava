package JframeTest;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
/**
 * 练习-完成一个完整的记事本界面 
 * @author Alice
 * @version 2019年8月6日
 */
public class MenuTest {
	public static void main(String[] args) {
		JFrame f=new JFrame("记事本");
		f.setLocation(200, 200);
		f.setSize(400, 300);
		/**
		 * 添加菜单栏
		 */
		JMenuBar menuBar=new JMenuBar();
		
		JMenu file=new JMenu("文件(F)");
		JMenu edit=new JMenu("编辑(E)");
		JMenu format=new JMenu("格式(O)");
		JMenu watch=new JMenu("查看(V)");
		JMenu help=new JMenu("帮助(H)");
		
		file.add(new JMenuItem("新建"));
		file.add(new JMenuItem("打开"));
		file.add(new JMenuItem("保存"));
		file.add(new JMenuItem("另存为"));
		file.add(new JMenuItem("新建"));
		file.addSeparator();
		file.add(new JMenuItem("页面设置"));
		file.add(new JMenuItem("打印"));
		file.addSeparator();
		file.add(new JMenuItem("退出"));
		
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(format);
		menuBar.add(watch);
		menuBar.add(help);
		/**
		 * 添加工具栏
		 */
		JToolBar toolBar=new JToolBar();
		JButton b1=new JButton("1");
		JButton b2=new JButton("2");
		JButton b3=new JButton("3");
		JButton b4=new JButton("4");
		JButton b5=new JButton("5");
		b1.setToolTipText("1");		// 给按钮设置提示信息
		toolBar.add(b1);
		toolBar.add(b2);
		toolBar.add(b3);
		toolBar.add(b4);
		toolBar.add(b5);
		
		toolBar.setFloatable(false);		 // 禁止工具栏拖动
		f.setLayout(new BorderLayout());	// 把工具栏放在north的位置
		f.add(toolBar,BorderLayout.NORTH);
		
		f.setJMenuBar(menuBar);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
