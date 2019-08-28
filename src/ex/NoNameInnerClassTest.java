package ex;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

class Method1{
	public static void start(int interval) {
		ActionListener listener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("the time is "+new Date());
			}
		};
		
		System.out.println("start");
		Timer myTimer=new Timer(interval, listener);
		myTimer.start();
	}
}
class Method2{
	public static void start(int interval) {
		//函数式接口，可以用到匿名内部类的地方就可以用lambda替代，更加易读
		ActionListener listener=event->System.out.println("the time is "+new Date());
		System.out.println("start");
		Timer myTimer=new Timer(interval, listener);
		myTimer.start();
		
	}
}


public class NoNameInnerClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		//Method1.start(2000);
		Method2.start(1500);
		
		JOptionPane.showMessageDialog(null, "quit?");
		System.exit(0);
	}

}
