package JframeTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class FileSeacrhFrame {
	public static int search(File filePath,String str)  {
		int num=0;
		if(filePath==null)
			return 0;
		File[] files=filePath.listFiles();
		if(files==null){
			System.out.println("空文件夹或者不是文件夹路径");
			return 0;
		}
		for(File x:files){
			if(x.isDirectory()){
				num+=search(x, str);
			}else if(x.getAbsolutePath().endsWith("java")){
				try(FileReader fReader=new FileReader(x)){
					char[] chGet=new char[(int)x.length()];
					fReader.read(chGet);
					String strGet=String.valueOf(chGet);
					if(strGet.contains(str)){
						System.out.printf("找到包含%s的文件：%s\n",str,x.getAbsolutePath());
						num+=1;
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		JFrame f=new JFrame("search");
		f.setSize(400, 300);
		f.setLocation(300, 200);
		f.setLayout(new BorderLayout());
		
		JButton searchB=new JButton("开始搜索");
		

		f.add(searchB,BorderLayout.SOUTH);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		 
		searchB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				searchB.setText("正在搜索...");
				searchB.setEnabled(false);
				SwingWorker<Integer, Void> worker=new SwingWorker<Integer,Void>(){
					@Override
					protected Integer doInBackground() throws Exception {
						File srcPath=new File("E:\\project\\CoreJava\\src\\ex");
						String findString="main";
						long time=System.currentTimeMillis();
						int num=search(srcPath, findString);
						time=System.currentTimeMillis()-time;
						System.out.println("耗时"+time+"毫秒");
						return num;
					}
				};
				worker.execute();
				
				while(!worker.isDone()){
					;
				}
				if(worker.isDone()){
					searchB.setEnabled(true);
					searchB.setText("开始搜索");
					try {
						int num=worker.get();
						JOptionPane.showMessageDialog(f, "找到"+num+"个文件");
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				
				
			}
		});
	}
}
