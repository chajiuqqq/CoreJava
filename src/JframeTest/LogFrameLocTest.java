package JframeTest;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import programme.Pair;
 /**
  * 使用了Thread每隔100ms记录窗口位置，并写入loc.txt
  * 创建一个窗口，如果位置记录文件不存在，则使用默认位置，如果存在，就使用上一次关闭时记录的位置
  * 
  * @author Alice
  * @version 2019年8月4日
  */
public class LogFrameLocTest {
	private JFrame f;
	private int xloc=200;
	private int yloc=200;		//默认大小
	public File storedFile;		//记录文件的路径
	
	public LogFrameLocTest() {
		// TODO Auto-generated constructor stub
		Pair<Integer> xyloc=new Pair<>();
		try {
			if(getStoredLoc(xyloc)){
				xloc=xyloc.getFirst();
				yloc=xyloc.getSecond();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		init(xloc,yloc);
		
	}
	/**
	 * 根据x，y，初始化窗口
	 * @param x
	 * @param y
	 */
	public void init(int x,int y) {
		// 主窗体
        f = new JFrame("LoL");
 
        // 主窗体设置大小
        f.setSize(400, 300);
 
        // 主窗体设置位置
        f.setLocation(x, y);
 
        // 主窗体中的组件设置为绝对定位
        f.setLayout(null);
 
        // 按钮组件
        JButton b = new JButton("一键秒对方基地挂");
 
        // 同时设置组件的大小和位置
        b.setBounds(50, 50, 280, 30);
 
        // 把按钮加入到主窗体中
        f.add(b);
       
        // 关闭窗体的时候，退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        f.setVisible(true);
	}
	
	/**
	 * 得到储存的位置
	 * @param xy
	 * @return
	 * @throws FileNotFoundException
	 */
	public boolean getStoredLoc(Pair<Integer> xy) throws FileNotFoundException {
		storedFile=new File("loc.txt");
		if(!storedFile.exists())	return false;

		Scanner sc=new Scanner(storedFile);
		while(sc.hasNext()){
			xy.setFirst(sc.nextInt());
			xy.setSecond(sc.nextInt());
		}
		sc.close();
		return true;
	}
	/**
	 * 得到当前窗口位置
	 * @return
	 */
	public Pair<Integer> getCurrentLoc() {
		int xloc=f.getX();
		int yloc=f.getY();
		return new Pair<Integer>(xloc, yloc);
	}
	/**
	 * 储存当前窗口位置
	 * @throws IOException
	 */
	public void storeLoc() throws IOException {
		Pair<Integer> loc=getCurrentLoc();
		FileWriter fw=new FileWriter(storedFile);
		System.out.println(loc);
		fw.write(loc.getFirst()+"");
		fw.write(" ");
		fw.write(loc.getSecond()+"");
		fw.close();
	}
	/**
	 * 测试
	 * @param args
	 */
    public static void main(String[] args) {
        LogFrameLocTest myFrame=new LogFrameLocTest();
      
        
        Thread logThread=new Thread(){
        	@Override
        	public void run() {
        		
        		while(true){
        			try {
						myFrame.storeLoc();
						Thread.sleep(100);	//每隔100ms储存位置
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
        		}
        	}
        };
        
        logThread.start();
 
    }
}