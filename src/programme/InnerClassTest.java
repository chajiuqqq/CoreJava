package programme;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassTest {
	public static void main(String[] args) {
		//�ⲿ���ʵ������
		TalkingClock myClock=new TalkingClock(2000, true);
		//����һ���ڲ���Ķ������������ָ����һ���ⲿ���ʵ�����󴴽����ڲ������
		//��Ϊ�ڲ��������Χ���ⲿ�ǲ��ɼ��ģ�����ֻ���ⲿ���ʵ��������ܵ����ڲ���Ĺ���������static�ڲ�����ⲿ�ǿɼ��ģ���ֱ��new������
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
