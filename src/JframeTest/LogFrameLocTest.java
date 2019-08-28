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
  * ʹ����Threadÿ��100ms��¼����λ�ã���д��loc.txt
  * ����һ�����ڣ����λ�ü�¼�ļ������ڣ���ʹ��Ĭ��λ�ã�������ڣ���ʹ����һ�ιر�ʱ��¼��λ��
  * 
  * @author Alice
  * @version 2019��8��4��
  */
public class LogFrameLocTest {
	private JFrame f;
	private int xloc=200;
	private int yloc=200;		//Ĭ�ϴ�С
	public File storedFile;		//��¼�ļ���·��
	
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
	 * ����x��y����ʼ������
	 * @param x
	 * @param y
	 */
	public void init(int x,int y) {
		// ������
        f = new JFrame("LoL");
 
        // ���������ô�С
        f.setSize(400, 300);
 
        // ����������λ��
        f.setLocation(x, y);
 
        // �������е��������Ϊ���Զ�λ
        f.setLayout(null);
 
        // ��ť���
        JButton b = new JButton("һ����Է����ع�");
 
        // ͬʱ��������Ĵ�С��λ��
        b.setBounds(50, 50, 280, 30);
 
        // �Ѱ�ť���뵽��������
        f.add(b);
       
        // �رմ����ʱ���˳�����
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // �ô����ÿɼ�
        f.setVisible(true);
	}
	
	/**
	 * �õ������λ��
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
	 * �õ���ǰ����λ��
	 * @return
	 */
	public Pair<Integer> getCurrentLoc() {
		int xloc=f.getX();
		int yloc=f.getY();
		return new Pair<Integer>(xloc, yloc);
	}
	/**
	 * ���浱ǰ����λ��
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
	 * ����
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
						Thread.sleep(100);	//ÿ��100ms����λ��
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