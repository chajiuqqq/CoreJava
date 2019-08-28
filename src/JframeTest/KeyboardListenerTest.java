package JframeTest;
  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
 /**
  * 窗体中有个图片和按钮，按下方向键图片会移动。按下按钮图片会出现/消失 
  * 使用了KeyboardListener
  * @author Alice
  * @version 2019年8月4日
  */
public class KeyboardListenerTest {
    public static void main(String[] args) {
  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);
  
        final JLabel l = new JLabel();
  
        ImageIcon i = new ImageIcon("C:\\Users\\Alice\\Pictures\\微信图片_20190601175123.jpg");
        l.setIcon(i);
        l.setBounds(50, 50, 150, 150);
        
        JButton button=new JButton("隐藏图片");
        button.setBounds(150,200,100,30);
        
        // 增加键盘监听
        f.addKeyListener(new KeyAdapter(){
  
            // 键被弹起
            public void keyReleased(KeyEvent e) {
            	System.out.println(e.getKeyCode());
                // 39代表按下了 “右键”
                if (e.getKeyCode() == 37) {
                 
                    l.setLocation(l.getX() - 10, l.getY());
                }
                if (e.getKeyCode() == 38) {
                  
                    l.setLocation(l.getX() , l.getY()-10);
                }
                if (e.getKeyCode() == 39) {
                   
                    l.setLocation(l.getX() + 10, l.getY());
                }
                if (e.getKeyCode() == 40) {
                   
                    l.setLocation(l.getX() , l.getY()+10);
                }
            }
  
            
        });
       
        button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(l.isVisible()){
					l.setVisible(false);
					button.setText("显示图片");
				}
				else{
					l.setVisible(true);
					button.setText("隐藏图片");
				}
			}
		});
		
        f.add(l);
        f.add(button);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
        f.setFocusable(true);
    }
}