package Table;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

/**
 * ����table
 * @author Alice
 * @version 2019��8��8��
 */
public class Ex8 {
	public static void main(String[] args) {
		JFrame f=new JFrame("table");
		f.setLocation(300, 200);
		f.setSize(400, 300);
		/**
		 * ����panel
		 */
		JLabel name=new JLabel("����:");
		JTextField namef=new JTextField();
		namef.setPreferredSize(new Dimension(100, 25));
		
		JLabel hp=new JLabel("Ѫ��:");
		JTextField hpf=new JTextField();
		hpf.setPreferredSize(new Dimension(100, 25));
		
		JButton addB=new JButton("����");
		
		JPanel pan=new JPanel();
		pan.add(name);
		pan.add(namef);
		pan.add(hp);
		pan.add(hpf);
		pan.add(addB);
		/**
		 * ����table����HeroTableModel�л�ȡ����
		 * ������ƺ����ݷ���
		 */
		HeroTableModel heros=new HeroTableModel();
		JTable table=new JTable(heros);
		
		//����ֻ�ܵ�ѡһ��
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//����Ĭ��ѡ�еڼ��е��ڼ���
		table.getSelectionModel().setSelectionInterval(0, 0);
		
		//��table������������
		JScrollPane sc=new JScrollPane(table);	
		
		/**
		 * ��������������ʾ���������˱߽粼��
		 * panel���ñ���table����center
		 */
		f.setLayout(new BorderLayout());
		f.add(pan,BorderLayout.NORTH);
		f.add(sc,BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		addB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=namef.getText();
				String hp=hpf.getText();
				double hpnum=0;
				/**
				 * Ϊ���ж�
				 */
				if("".equals(name)||"".equals(hp)){
					JOptionPane.showMessageDialog(f, "�����пգ�"); 
					return;
				}
				
				/**
				 * ��֤hp�Ϸ�
				 */
				try {
					hpnum=Double.parseDouble(hp);
				} catch (NumberFormatException e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(f, "�����hpֻ��Ϊ���֣�"); 
					return;
				}
				
				
				//�����µ�hero����
				Hero hero=new Hero(0, name, hpnum, 0.0);
				
				//����DAO�����ڲ����¶���ͷ��ظ��º�������б�
				HeroDAO dao=new HeroDAO();
				dao.add(hero);
				
				//��������Tablemodel������ԴΪ�µ�list������Ҳ�͸�����table������
				heros.setList(dao.list());
				
				//ˢ��table��ʾ
				table.updateUI();
				
				
			}
		});
	}
	
	
}
