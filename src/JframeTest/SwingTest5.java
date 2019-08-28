package JframeTest;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
/**
 * 练习-进度条
 * 刚开始加的比较快，以每隔100毫秒的速度增加，随着进度的增加，越加越慢，让处女座的使用者，干着急
 * 
 * @author Alice
 * @version 2019年8月5日
 */
public class SwingTest5 {
	public static void main(String[] args) {
		JFrame f=new JFrame("test2");
		f.setLocation(50, 50);
		f.setSize(400, 300);
		f.setLayout(new FlowLayout());
		
		JProgressBar pb=new JProgressBar();
		pb.setStringPainted(true);
		pb.setMaximum(100);
		pb.setValue(0);
		
		f.add(pb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		Thread t=new Thread(){
			@Override
			public void run() {
				int i=0;
			
				int percent=50+(int)(Math.random()*10)*5;
				System.out.println(percent);
				while(pb.getValue()!=100){
					
					try {
						for(;i<=100;i++){
							pb.setValue(i);
							if(i<percent)
								Thread.sleep(100-i);
							else{
								Thread.sleep(200+i);
							}
							
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(f, "下载完成！");
			}
		};
		t.start();
		
			
	}
}
