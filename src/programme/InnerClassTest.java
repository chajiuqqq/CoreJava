package programme;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassTest {
	public static void main(String[] args) {
		//外部类的实例对象
		TalkingClock myClock=new TalkingClock(2000, true);
		//声明一个内部类的对象变量，让它指向由一个外部类的实例对象创建的内部类对象
		//因为内部类对于外围类外部是不可见的，所以只有外部类的实例对象才能调用内部类的构造器。（static内部类对外部是可见的，可直接new出来）
		TalkingClock.TimerPrinter lisPrinter=myClock.new TimerPrinter();
		myClock.start();
		
		JOptionPane.showMessageDialog(null, "quit ?");
		System.exit(0);
	}
}

class TalkingClock{
	private int interval=0;
	private boolean beep=false;

	public TalkingClock(int interval, boolean beep) {
		this.interval=interval;
		this.beep=beep;
	}
	
	public void start() {
		ActionListener myActionListener=new TimerPrinter();
		Timer myTimer=new Timer(interval, myActionListener);
		myTimer.start();
	}
	
	public void tst() {
	
		TimerPrinter aPrinter=new TimerPrinter();
		aPrinter.tt();
		
		
	}
	
	public class TimerPrinter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("the time is "+new Date());
			if(beep)	Toolkit.getDefaultToolkit().beep();
		}
		
		public void tt() {
			System.out.println("tt");
		}
		/**
		 * error
		public static void ss() {  
			System.out.println("ss");
		}
		*/
	}
	
}
