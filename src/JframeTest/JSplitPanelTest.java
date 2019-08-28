package JframeTest;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class JSplitPanelTest {
	public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
        
        /**
         * ÉèÖÃpleft
         */
        JPanel pleft=new JPanel();
        pleft.setBounds(10, 10, 200, 300);
        pleft.setBackground(Color.red);
        JButton zyy1=new JButton("zyy1");
        JButton zyy2=new JButton("zyy2");
        JButton zyy3=new JButton("zyy3");
        pleft.add(zyy1);
        pleft.add(zyy2);
        pleft.add(zyy3);
        
        /**
         * ÉèÖÃpright
         */
        JPanel pright=new JPanel();
        pright.setLayout(null);
        JLabel Lpic=new JLabel();
        Lpic.setBounds(50, 40, 200, 200);
        pright.add(Lpic);
        pright.setBackground(Color.blue);
        
        JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pleft, pright);
        sp.setDividerLocation(80);
        
        
        /**
         * ÉèÖÃ¼àÌýÆ÷
         */
        ActionListener listener=(e)->{
        	ImageIcon icon;
        	if(e.getSource()==zyy1){
        		icon=new ImageIcon("C:\\Users\\Alice\\Pictures\\zyy1.jpg");
        		Lpic.setIcon(icon);
        	}
        	if(e.getSource()==zyy2){
        		icon=new ImageIcon("C:\\Users\\Alice\\Pictures\\zyy2.jpg");
        		Lpic.setIcon(icon);
        	}
        	if(e.getSource()==zyy3){
        		icon=new ImageIcon("C:\\Users\\Alice\\Pictures\\zyy3.jpg");
        		Lpic.setIcon(icon);
        	}
        };
        
        zyy1.addActionListener(listener);
        zyy2.addActionListener(listener);
        zyy3.addActionListener(listener);
        
        
        /**
         * fset
         */
        f.setContentPane(sp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}
}
