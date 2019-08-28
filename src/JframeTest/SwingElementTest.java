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
		 * JLabel�����ͼƬ
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
		 * ��ѡ��JCheckBox
		 */
		JCheckBox checkBox1=new JCheckBox("����");
		checkBox1.setSelected(true);
		checkBox1.setBounds(10, 180, 100, 30);
		JCheckBox checkBox2=new JCheckBox("����");
		checkBox2.setSelected(false);
		checkBox2.setBounds(10, 210, 100, 30);
		f.add(checkBox1);
		f.add(checkBox2);
		
		/**
		 * ��ѡ��ť�Ͱ�ť��
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
		 * �����˵�		JComboBox
		 */
		String[] heros={"timo","gailun"};
		JComboBox<String> cb=new JComboBox<>(heros);
		cb.setBounds(10, 250, 50, 50);
		f.add(cb);
		
		/**
		 * ѡ����� ����
		 * JOptionPane
		 */
		int option=JOptionPane.showConfirmDialog(f,"�Ƿ�ʹ�����"); 
		if(option==JOptionPane.OK_OPTION){
			String answer=JOptionPane.showInputDialog(f,"������yes��ȷ�����ѡ��");
			if("yes".equals(answer))
				JOptionPane.showMessageDialog(f,"�㱻�����");
		}
		
		/**
		 * �����ı���	JTextField
		 */
		JLabel username=new JLabel("�û���");
		username.setBounds(150, 10, 50, 30);
		JTextField nameField=new JTextField("name");
		nameField.setBounds(200,10,150,30);
		
		
		/**
		 * �����ı���	JPasswordField
		 */
		JLabel password=new JLabel("����");
		password.setBounds(150, 40, 50, 30);
		JPasswordField passwordField=new JPasswordField("");
		passwordField.setBounds(200,40,150,30);
		
		JButton submit=new JButton("�ύ");
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
		 * �ı�����  JTextArea 
		 */
		JTextArea textArea=new JTextArea("write here");
		textArea.setBounds(150, 110, 150, 50);
		textArea.setText("123");
		textArea.append("456789\n");	//�ֶ��ӻ��з�
		textArea.append("9999");
		textArea.setLineWrap(true);		//�����Զ�����
		f.add(textArea);
		
		/**
		 * ������	JProgressBar	
		 */
		JProgressBar bar=new JProgressBar();
		bar.setBounds(400, 10, 200, 30);
		bar.setMaximum(100);
		bar.setValue(51);	
		bar.setStringPainted(true);	//�Ƿ���ʾ���Ȱٷֱ�
		f.add(bar);
		
		
		/**
		 * �ļ�ѡ����	JFileChooser
		 * ���Դ��ļ��ͱ����ļ�
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
					JOptionPane.showMessageDialog(f, "�ƻ����ļ���"+path);
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
					JOptionPane.showMessageDialog(f, "�ƻ����浽�ļ���"+path);
				}
			
			}
		});
		
		f.add(open);
		f.add(save);
		f.add(fc);
		
		
		
		
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setFocusable(true);
		f.setVisible(true);
		nameField.grabFocus();	//��궨λ��nameField
		
	}
	
}
