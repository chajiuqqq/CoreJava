package JframeTest;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * 做了4*5的计算器按钮布局
 * 三种布局方式
 * FlowLayout()：流式布局，容器上的组件水平摆放
 * 			f.setLayout(new FlowLayout());
 * BorderLayout()：边界布局，容器上的组件按照上北下南左西右东中的顺序摆放	
 * 			f.setLayout(new BorderLayout());
 * 			加入到容器的时候，需要指定位置
	        f.add(b1, BorderLayout.NORTH);
	        f.add(b2, BorderLayout.SOUTH);
 * GridLayout：网格布局器，该GridLayerout的构造方法表示该网格是2行3列
        	f.setLayout(new GridLayout(2, 3));
 * @author Alice
 * @version 2019年8月4日
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
