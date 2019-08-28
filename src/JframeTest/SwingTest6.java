package JframeTest;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
/**
 * ��ϰ-��ʾ�ļ��и��ƽ�����
 * �ļ��и��ƾͲ�˵�ˣ�ֵ��ע������ڰ��¿�ʼ���ư�ť�󣬶��ļ��ĸ��ƣ�ʹ��һ���̴߳���ͬʱ������һ���̣߳����ƽ�����
 * �����������Ѹ��Ƶ��ֽ�����Ŀ��Ŀ¼���ֽ�����С֮������
 * @author Alice
 * @version 2019��8��5��
 */
public class SwingTest6 {
	JFrame f;
	JProgressBar pb;
	JButton startB;
	JLabel fromL;
	JLabel toL;
	JLabel percentL;
	JTextField fromT;
	JTextField toT;
	long totalSize=0;
	long completedSize=0;
	
	public SwingTest6() {
		// TODO Auto-generated constructor stub
		init();
		
	}
	/**
	 * ��ʼ������
	 */
	public void init() {
		f=new JFrame("test2");
		f.setLocation(300, 200);
		f.setSize(600, 150);
		f.setLayout(new FlowLayout());
		
		fromL=new JLabel("Դ�ļ���:");
		toL=new JLabel("���Ƶ�:");
		percentL=new JLabel("�ļ����ƽ���:");

		fromT=new JTextField("C:\\Users\\Alice\\Pictures");
		toT=new JTextField("C:\\Users\\Alice\\Desktop\\to");
		
		startB=new JButton("��ʼ����");
		
		pb=new JProgressBar();
		
		fromT.setPreferredSize(new Dimension(180,30));
		toT.setPreferredSize(new Dimension(180,30));
		
		pb.setStringPainted(true);
		pb.setMaximum(100);
		pb.setValue(0);
		
		
		f.add(fromL);
		f.add(fromT);
		f.add(toL);
		f.add(toT);
		f.add(startB);
		f.add(percentL);
		f.add(pb);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		listener();
	}
	
	/**
	 * ���Ӱ�ť����
	 */
	public void listener() {
		startB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String from=fromT.getText();
				String to=toT.getText();
				if(!from.equals("")&&!toT.equals("")&&!from.contains("\\")&&!to.contains("\\")){
					JOptionPane.showMessageDialog(f, "·������ȷ��");
					return;
				}
				totalSize=calTotalSize(new File(from));
				startB.setText("���ڸ���");
				/**
				 * ִ�и��Ʋ���
				 */
				Thread t1=new Thread(){
					@Override
					public void run() {
							if(copyFolder(new File(from), new File(to))){
								JOptionPane.showMessageDialog(f, "������ɣ�");
								pb.setValue(0);
								startB.setText("��ʼ����");
							}else{
								JOptionPane.showMessageDialog(f, "����ʧ�ܣ�");
						}
					}
				};
				t1.start();
				/**
				 * ִ�и��½���������
				 */
				Thread t2=new Thread(){
					@Override
					public void run() {
						while(totalSize!=completedSize&&totalSize!=0){
							pb.setValue((int)(completedSize*100.0/totalSize));
							System.out.println(completedSize+"/"+totalSize);
						}
					}
				};
				t2.start();
				
			
			}
		});
	}
	
	/**
	 * ���ݸ���ԭ·����Ŀ��·�������ļ���
	 * @param fromFolder	ԭ·��	
	 * @param toFolder		Ŀ��·��
	 * @return	�Ƿ��Ƴɹ�
	 */
	public  boolean copyFolder(File fromFolder,File toFolder) {
		
		if(fromFolder.equals(toFolder)){
			return false;
		}
		File[] files=fromFolder.listFiles();
		if(files==null)
			return false;
		if(!toFolder.exists())
			toFolder.mkdirs();
		for(File x:files){
			if(x.isDirectory()){
				File nextFromFolder=new File(fromFolder, x.getName());
				File nextToFolder=new File(toFolder, x.getName());
				copyFolder(nextFromFolder, nextToFolder);
			}else{
				/**
				 * ��Ϊ������ͼƬ�����Բ���ʹ���ַ���FileReader��Ҫʹ���ֽ�����FileInputStream
				 */
				try(FileInputStream reader=new FileInputStream(x);
						FileOutputStream writer=new FileOutputStream(new File(toFolder, x.getName()));) {
					byte[] src=new byte[(int)x.length()];
					reader.read(src);
					writer.write(src);
					completedSize+=x.length();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return true;
		
	}
	
	/**
	 * ����Ŀ��·�����ֽڴ�С
	 * @param f	Ŀ��·��
	 * @return	Ŀ��·�����ֽڴ�Сlong
	 */
	public long calTotalSize(File f) {
		long size=0;
		File[] files=f.listFiles();
		if(files==null)
			return f.isFile()?f.length():0;
		for(File x:files){
			if(x.isDirectory()){
				size+=calTotalSize(x);
			}else{
				size+=x.length();
			}
		}
		return size;
		
	}
	
	public static void main(String[] args) {
		
		SwingTest6 a=new SwingTest6();

		
	
	}
}
