package ex;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;
class TimePrinter implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("the time is "+ new Date());
		//beep ·¢³öÁåÏì
		Toolkit.getDefaultToolkit().beep();
	}
	
}

public class TimerTest_6_2_1 {

    public static void main(String[] args) {
    	ActionListener aPrinter=new TimePrinter();
    	Timer aTimer=new Timer(1000, aPrinter);
    	aTimer.start();
    	JOptionPane.showMessageDialog(null, "start?");
    	System.exit(0);
    }



}
