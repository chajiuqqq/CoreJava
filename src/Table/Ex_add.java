package Table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class Ex_add {

	public static void main(String[] args) {
		JFrame f=new JFrame("table");
		f.setLocation(300, 200);
		f.setSize(400, 300);
		
		/**
		 * ����Jdialog
		 */
		JDialog addDia=new JDialog();
		addDia.setBounds(400, 300,300, 150);
		addDia.setModal(true);
		addDia.setLayout(new FlowLayout());
		
		/**
		 * ����add����Jdialog���ڿؼ�
		 */
		JLabel name=new JLabel("����:");
		name.setPreferredSize(new Dimension(100, 25));
		JTextField namef=new JTextField();
		namef.setPreferredSize(new Dimension(150, 25));
		
		JLabel hp=new JLabel("Ѫ��:");
		hp.setPreferredSize(new Dimension(100, 25));
		JTextField hpf=new JTextField();
		hpf.setPreferredSize(new Dimension(150, 25));
		
		JButton submitB=new JButton("�ύ");

		addDia.add(name);
		addDia.add(namef);
		addDia.add(hp);
		addDia.add(hpf);
		addDia.add(submitB);
		
		addDia.setVisible(false);
		
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
		 * ���õײ���ť��
		 */
		JPanel bottom=new JPanel();
		JButton addB=new JButton("���");
		
		bottom.add(addB);
		
		
		/**
		 * ��������������ʾ���������˱߽粼��
		 * panel���ñ���table����center
		 */
		f.setLayout(new BorderLayout());
		f.add(bottom,BorderLayout.SOUTH);
		f.add(sc,BorderLayout.NORTH);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
		/**
		 * ���ü�����
		 */
		addB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addDia.setVisible(true);
			}
		});
		
		submitB.addActionListener(new ActionListener() {
			
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
				
				//��ʾ��ӳɹ�
				JOptionPane.showMessageDialog(addDia, "��ӳɹ���");
				
				//ˢ��table��ʾ
				table.updateUI();
				
				//�ر�Jdialog
				addDia.setVisible(false);
				
			}
		});
	}
	
}
