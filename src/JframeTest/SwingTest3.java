package JframeTest;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * ��ϰ-�˺�������֤
 * @author Alice
 * @version 2019��8��5��
 */
public class SwingTest3 {
	/**
	 * ����ע�ᰴť���õĺ���
	 * @param name
	 * @param password
	 * @return
	 */
	public static boolean register(String name,String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try(Connection c=DriverManager.getConnection(
	                            "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
	                            "root", "admin");
				Statement s = c.createStatement();){
			String st=String.format("insert into user value('%s','%s')",name,password);
			s.execute(st);
			return true;
		}catch (ClassCastException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * ���ڵ�¼��ť���õĺ���
	 * @param name
	 * @param password
	 * @return
	 */
	public static boolean login(String name,String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try(Connection c=DriverManager.getConnection(
	                            "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
	                            "root", "admin");
				Statement s = c.createStatement();){
			String st=String.format("select * from user where name = '%s' and password = '%s'",name,password);
			ResultSet result=s.executeQuery(st);
			if(result.next())	
				return true;
		}catch (ClassCastException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		JFrame f=new JFrame("test3");
		f.setLocation(200, 250);
		f.setSize(400, 300);
		f.setLayout(null);
		
		JLabel name=new JLabel("username:");
		JLabel password=new JLabel("password:");
		JTextField namefield=new JTextField();
		JPasswordField passwordfield=new JPasswordField();
		JButton bRegister=new JButton("ע��");
		JButton bLogin=new JButton("��¼");
		
		name.setBounds(50, 10, 100, 30);
		namefield.setBounds(150, 10, 150, 30);

		password.setBounds(50, 40, 100, 30);
		passwordfield.setBounds(150, 40, 150, 30);
		
		bLogin.setBounds(50, 70, 100, 30);
		bRegister.setBounds(150, 70, 100, 30);
		f.add(name);
		f.add(namefield);
		f.add(password);
		f.add(passwordfield);
		f.add(bLogin);
		f.add(bRegister);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		ActionListener listener=(e)->{
			String namestr=namefield.getText();
			String passwordstr=String.valueOf(passwordfield.getPassword());
			if(e.getSource()==bLogin)
				if(login(namestr, passwordstr))
					JOptionPane.showMessageDialog(f, "��¼�ɹ���");
				else {
					JOptionPane.showMessageDialog(f, "��¼ʧ�ܣ��˺Ż��������");
				}
			if(e.getSource()==bRegister)
				if(register(namestr, passwordstr))
					JOptionPane.showMessageDialog(f, "ע��ɹ�������˺��ǣ�"+namestr+"\n�����ǣ�"+passwordstr);
				else {
					JOptionPane.showMessageDialog(f, "ע��ʧ�ܣ��û������ظ���");
				}
		};
		
		bLogin.addActionListener(listener);
		bRegister.addActionListener(listener);	
	}
}


