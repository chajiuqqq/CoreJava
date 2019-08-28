package JframeTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

public class SwingElementTest {
	
	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setBounds(100, 100, 800, 400);
		f.setLayout(null);
		/**
		 *JLabel
		 */
		JLabel label=new JLabel("JLabel");
		label.setBounds(10, 10, 50, 30);
		f.add(label);
		
		/**
		 * JLabel里添加图片
		 */
		ImageIcon img=new ImageIcon("C:\\Users\\Alice\\Pictures\\Saved Pictures\\1.jpg");
		JLabel pic=new JLabel();
		pic.setIcon(img);
		pic.setBounds(10,40,100,100);
		f.add(pic);
		/**
		 * JButton
		 */
		JButton button=new JButton("button");
		button.setBounds(10, 150, 100, 30);
		f.add(button);
		
		/**
		 * 多选框JCheckBox
		 */
		JCheckBox checkBox1=new JCheckBox("美术");
		checkBox1.setSelected(true);
		checkBox1.setBounds(10, 180, 100, 30);
		JCheckBox checkBox2=new JCheckBox("音乐");
		checkBox2.setSelected(false);
		checkBox2.setBounds(10, 210, 100, 30);
		f.add(checkBox1);
		f.add(checkBox2);
		
		/**
		 * 单选按钮和按钮组
		 * JRadioButton	ButtonGroup
		 */
		JRadioButton radioButton1=new JRadioButton("timo");
		JRadioButton radioButton2=new JRadioButton("gailun");
		radioButton1.setBounds(110,180, 100, 30);
		radioButton2.setBounds(110, 200, 100, 30);
		ButtonGroup group=new ButtonGroup();
		group.add(radioButton1);
		group.add(radioButton2);
		f.add(radioButton1);
		f.add(radioButton2);
		
		/**
		 * 下拉菜单		JComboBox
		 */
		String[] heros={"timo","gailun"};
		JComboBox<String> cb=new JComboBox<>(heros);
		cb.setBounds(10, 250, 50, 50);
		f.add(cb);
		
		/**
		 * 选项面板 三个
		 * JOptionPane
		 */
		int option=JOptionPane.showConfirmDialog(f,"是否使用外挂"); 
		if(option==JOptionPane.OK_OPTION){
			String answer=JOptionPane.showInputDialog(f,"请输入yes来确认你的选择");
			if("yes".equals(answer))
				JOptionPane.showMessageDialog(f,"你被检测了");
		}
		
		/**
		 * 单行文本框	JTextField
		 */
		JLabel username=new JLabel("用户名");
		username.setBounds(150, 10, 50, 30);
		JTextField nameField=new JTextField("name");
		nameField.setBounds(200,10,150,30);
		
		
		/**
		 * 密码文本框	JPasswordField
		 */
		JLabel password=new JLabel("密码");
		password.setBounds(150, 40, 50, 30);
		JPasswordField passwordField=new JPasswordField("");
		passwordField.setBounds(200,40,150,30);
		
		JButton submit=new JButton("提交");
		submit.setBounds(150,70,100,30);
		
		ActionListener textFieldListener=(e)->{
			String nameval=nameField.getText();
			String passwordval=String.valueOf(passwordField.getPassword());
			if(e.getSource()==nameField&&!nameval.equals(""))
				System.out.println("username:"+nameval);
			if(e.getSource()==passwordField&&!passwordval.equals("")){
				System.out.println("username:"+passwordval);
			}
			if(e.getSource()==submit&&!nameval.equals("")&&!passwordval.equals("")){
				System.out.println("username:"+nameval);
				System.out.println("username:"+passwordval);
			}
		};
		nameField.addActionListener(textFieldListener);
		passwordField.addActionListener(textFieldListener);
		submit.addActionListener(textFieldListener);
		
		f.add(username);
		f.add(nameField);
		f.add(password);
		f.add(passwordField);
		f.add(submit);
		
		/**
		 * 文本区域  JTextArea 
		 */
		JTextArea textArea=new JTextArea("write here");
		textArea.setBounds(150, 110, 150, 50);
		textArea.setText("123");
		textArea.append("456789\n");	//手动加换行符
		textArea.append("9999");
		textArea.setLineWrap(true);		//设置自动换行
		f.add(textArea);
		
		/**
		 * 进度条	JProgressBar	
		 */
		JProgressBar bar=new JProgressBar();
		bar.setBounds(400, 10, 200, 30);
		bar.setMaximum(100);
		bar.setValue(51);	
		bar.setStringPainted(true);	//是否显示进度百分比
		f.add(bar);
		
		
		/**
		 * 文件选择器	JFileChooser
		 * 可以打开文件和保存文件
		 */
		JButton open=new JButton("open");
		JButton save=new JButton("save");
		open.setBounds(400, 50, 100, 30);
		save.setBounds(510,50,100,30);
		
		JFileChooser fc=new JFileChooser();
		fc.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return ".jpg";
			}
			
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getName().toLowerCase().endsWith(".jpg");
			}
		});
		
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int status=fc.showOpenDialog(f);
				String path=fc.getSelectedFile().getAbsolutePath();
				if(status==JFileChooser.APPROVE_OPTION){
					JOptionPane.showMessageDialog(f, "计划打开文件："+path);
				}
				
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int status=fc.showSaveDialog(f);
				String path=fc.getSelectedFile().getAbsolutePath();
				if(status==JFileChooser.APPROVE_OPTION){
					JOptionPane.showMessageDialog(f, "计划保存到文件："+path);
				}
			
			}
		});
		
		f.add(open);
		f.add(save);
		f.add(fc);
		
		
		
		
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setFocusable(true);
		f.setVisible(true);
		nameField.grabFocus();	//光标定位在nameField
		
	}
	
}
