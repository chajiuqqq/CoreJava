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
 * 练习-统计文件数量
 * 借助时间控件，选中一个时间，然后根据这个时间，统计e:\project 修改时间大于这个时间的文件，一共有多少
 * @author Alice
 * @version 2019年8月8日
 */
public class dateTest2 {
	public static void main(String[] args) {
		JFrame f=new JFrame("date");
		f.setLocation(300,200);
		f.setSize(400, 300);
		
		/**
		 * 日期控件和按钮
		 */
		JXDatePicker picker=new JXDatePicker();
		picker.setDate(new Date());
		picker.setPreferredSize(new Dimension(200,30));
		JButton button=new JButton("统计e:\\project 修改时间大于这个时间的文件");
		
		
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
				
				JOptionPane.showMessageDialog(f, "修改时间大于"+date+"的java文件有："+num+"个"+"\n占比"+percent+"%");
			}
		});
	}
	
	/**
	 * 统计 filePath下修改日期在date前的.java文件个数
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
			System.out.println("空文件夹或者不是文件夹路径");
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
	 * 统计 filePath下.java文件个数
	 * @param filePath
	 * @return
	 */
	public static int countTotal(File filePath)  {
		int number=0;
		if(filePath==null)
			return 0;
		File[] files=filePath.listFiles();
		if(files==null){
			System.out.println("空文件夹或者不是文件夹路径");
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
