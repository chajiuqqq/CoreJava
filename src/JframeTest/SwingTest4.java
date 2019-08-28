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
 * 练习-黄鹤 
 * @author Alice
 * @version 2019年8月5日
 */
public class SwingTest4 {
	/**
	 * 判断是否为合法数字输入
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
		
		JLabel L1=new JLabel("地名:");
		JLabel L2=new JLabel("公司类型:");
		JLabel L3=new JLabel("公司名称:");
		JLabel L4=new JLabel("老板名称:");
		JLabel L5=new JLabel("金额:");
		JLabel L6=new JLabel("产品:");
		JLabel L7=new JLabel("价格计量单位:");
		
		JTextField t1=new JTextField("浙江温州");
		JTextField t2=new JTextField("皮革厂");
		JTextField t3=new JTextField("江南皮革厂");
		JTextField t4=new JTextField("黄鹤");
		JTextField t5=new JTextField("3.5");
		JTextField t6=new JTextField("钱包");
		JTextField t7=new JTextField("百");
		
		JButton button=new JButton("生成");
		
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
		 * 对button添加监听器
		 */
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/**
				 * 获取输入内容
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
				 * 空值检测
				 */
				for(String x:s){
					if("".equals(x)){
						JOptionPane.showMessageDialog(f, "输入有空值！");
						return; 
					}
				}
				/**
				 * 数字检测
				 */
				if(!judge(s[5])){
					JOptionPane.showMessageDialog(f, "金额请输入正确的数字！");
					return; 
				}
					
				/**
				 * 生成
				 */
				String all=String.format("%s最大%s%s倒闭了，"
						+ "王八蛋老板%s吃喝嫖赌，欠下了%s个亿，带着他的小姨子跑了!"
						+ "我们没有办法，拿着%s抵工资!原价都是一%s多、两%s多、三%s多的钱包，"
						+ "现在全部只卖二十块，统统只要二十块!%s王八蛋，你不是人!"
						+ "我们辛辛苦苦给你干了大半年，你不发工资，"
						+ "你还我血汗钱，还我血汗钱!", s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[7],s[7],s[4]);
				area.setText(all);
			}
		});
	
		
			
	}
}
