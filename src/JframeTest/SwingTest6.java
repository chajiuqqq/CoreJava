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
 * 练习-显示文件夹复制进度条
 * 文件夹复制就不说了，值得注意的是在按下开始复制按钮后，对文件的复制，使用一个线程处理，同时激活另一个线程，控制进度条
 * 进度条根据已复制的字节数和目标目录的字节数大小之比设置
 * @author Alice
 * @version 2019年8月5日
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
	 * 初始化窗口
	 */
	public void init() {
		f=new JFrame("test2");
		f.setLocation(300, 200);
		f.setSize(600, 150);
		f.setLayout(new FlowLayout());
		
		fromL=new JLabel("源文件夹:");
		toL=new JLabel("复制到:");
		percentL=new JLabel("文件复制进度:");

		fromT=new JTextField("C:\\Users\\Alice\\Pictures");
		toT=new JTextField("C:\\Users\\Alice\\Desktop\\to");
		
		startB=new JButton("开始复制");
		
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
	 * 增加按钮监听
	 */
	public void listener() {
		startB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String from=fromT.getText();
				String to=toT.getText();
				if(!from.equals("")&&!toT.equals("")&&!from.contains("\\")&&!to.contains("\\")){
					JOptionPane.showMessageDialog(f, "路径不正确！");
					return;
				}
				totalSize=calTotalSize(new File(from));
				startB.setText("正在复制");
				/**
				 * 执行复制操作
				 */
				Thread t1=new Thread(){
					@Override
					public void run() {
							if(copyFolder(new File(from), new File(to))){
								JOptionPane.showMessageDialog(f, "拷贝完成！");
								pb.setValue(0);
								startB.setText("开始复制");
							}else{
								JOptionPane.showMessageDialog(f, "拷贝失败！");
						}
					}
				};
				t1.start();
				/**
				 * 执行更新进度条操作
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
	 * 根据给的原路径和目标路径复制文件夹
	 * @param fromFolder	原路径	
	 * @param toFolder		目标路径
	 * @return	是否复制成功
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
				 * 因为可能有图片，所以不能使用字符流FileReader，要使用字节流类FileInputStream
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
	 * 计算目标路径的字节大小
	 * @param f	目标路径
	 * @return	目标路径的字节大小long
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
