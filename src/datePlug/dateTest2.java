package datePlug;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jdesktop.swingx.JXDatePicker;
/**
 * ��ϰ-ͳ���ļ�����
 * ����ʱ��ؼ���ѡ��һ��ʱ�䣬Ȼ��������ʱ�䣬ͳ��e:\project �޸�ʱ��������ʱ����ļ���һ���ж���
 * @author Alice
 * @version 2019��8��8��
 */
public class dateTest2 {
	public static void main(String[] args) {
		JFrame f=new JFrame("date");
		f.setLocation(300,200);
		f.setSize(400, 300);
		
		/**
		 * ���ڿؼ��Ͱ�ť
		 */
		JXDatePicker picker=new JXDatePicker();
		picker.setDate(new Date());
		picker.setPreferredSize(new Dimension(200,30));
		JButton button=new JButton("ͳ��e:\\project �޸�ʱ��������ʱ����ļ�");
		
		
		f.add(picker);
		f.add(button);
		f.setLayout(new FlowLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date date=picker.getDate();
				int num=count(new File("e:\\project"), date);
				int total=countTotal(new File("e:\\project"));
				String percent=String.format("%.2f", num*100.0/total);
				
				JOptionPane.showMessageDialog(f, "�޸�ʱ�����"+date+"��java�ļ��У�"+num+"��"+"\nռ��"+percent+"%");
			}
		});
	}
	
	/**
	 * ͳ�� filePath���޸�������dateǰ��.java�ļ�����
	 * @param filePath
	 * @param date
	 * @return
	 */
	public static int count(File filePath,Date date)  {
		int number=0;
		if(filePath==null)
			return 0;
		File[] files=filePath.listFiles();
		if(files==null){
			System.out.println("���ļ��л��߲����ļ���·��");
			return 0;
		}
		for(File x:files){
			if(x.isDirectory()){
				number+=count(x,date);
			}else if(x.getAbsolutePath().endsWith("java")&&x.lastModified()>date.getTime()){
				System.out.println(x.getAbsolutePath());
				number+=1;
			}
		}
		return number;
	}
	/**
	 * ͳ�� filePath��.java�ļ�����
	 * @param filePath
	 * @return
	 */
	public static int countTotal(File filePath)  {
		int number=0;
		if(filePath==null)
			return 0;
		File[] files=filePath.listFiles();
		if(files==null){
			System.out.println("���ļ��л��߲����ļ���·��");
			return 0;
		}
		for(File x:files){
			if(x.isDirectory()){
				number+=countTotal(x);
			}else if(x.getAbsolutePath().endsWith("java")){
				number+=1;
			}
		}
		return number;
	}
}
