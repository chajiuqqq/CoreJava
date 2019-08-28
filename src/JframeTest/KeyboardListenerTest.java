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
  * �������и�ͼƬ�Ͱ�ť�����·����ͼƬ���ƶ������°�ťͼƬ�����/��ʧ 
  * ʹ����KeyboardListener
  * @author Alice
  * @version 2019��8��4��
  */
public class KeyboardListenerTest {
    public static void main(String[] args) {
  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);
  
        final JLabel l = new JLabel();
  
        ImageIcon i = new ImageIcon("C:\\Users\\Alice\\Pictures\\΢��ͼƬ_20190601175123.jpg");
        l.setIcon(i);
        l.setBounds(50, 50, 150, 150);
        
        JButton button=new JButton("����ͼƬ");
        button.setBounds(150,200,100,30);
        
        // ���Ӽ��̼���
        f.addKeyListener(new KeyAdapter(){
  
            // ��������
            public void keyReleased(KeyEvent e) {
            	System.out.println(e.getKeyCode());
                // 39�������� ���Ҽ���
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
					button.setText("��ʾͼƬ");
				}
				else{
					l.setVisible(true);
					button.setText("����ͼƬ");
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