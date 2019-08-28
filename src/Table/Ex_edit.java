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

public class Ex_edit {
	static JFrame f=new JFrame("table");
	static HeroTableModel heros=new HeroTableModel();
	static JTable table=new JTable(heros);
	public static void main(String[] args) {
		
		f.setLocation(300, 200);
		f.setSize(400, 300);
		
		/**
		 * ����table����
		 */
		
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
		JButton delB=new JButton("ɾ��");
		JButton editB=new JButton("�༭");
		
		bottom.add(addB);
		bottom.add(delB);
		bottom.add(editB);
		
		
		
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
				AddDialog dia=new AddDialog(f);
				dia.setVisible(true);
			
			}
		});
		

		delB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				int delId=(int)heros.getValueAt(row, 0);
				HeroDAO dao=new HeroDAO();
				
				int value=JOptionPane.showConfirmDialog(f, "ȷ��ɾ����");
				if(value==JOptionPane.YES_OPTION){
					dao.delete(delId);					
					heros.setList(dao.list());
					table.updateUI();
				}
			}
		});
		
		
		editB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selection=table.getSelectedRow();
				if(-1==selection){
					JOptionPane.showMessageDialog(f, "��ѡ��Ҫ�༭��Ӣ��");
					return;
				}
				/**
				 * ��ȡѡ���е����ֺ�hp
				 */
				String name=(String)heros.getValueAt(selection, 1);
				double hp=(double)heros.getValueAt(selection, 2);
				/**
				 * ����EditDialog 
				 */
				EditDialog dia=new EditDialog(f);
				dia.setNamef(name);
				dia.setHpf(hp);
				
				dia.setVisible(true);
			
			}
		});
	
	}
	/**
	 * ����Ϸ����ж�
	 * @param name
	 * @param hp
	 * @return
	 */
	public static boolean legalJudge(String name,String hp) {
		/**
		 * Ϊ���ж�
		 */
		if("".equals(name)||"".equals(hp)){
			JOptionPane.showMessageDialog(f, "�����пգ�"); 
			return false;
		}
		
		/**
		 * ��֤hp�Ϸ�
		 */
		try {
			double hpnum=Double.parseDouble(hp);
		} catch (NumberFormatException e1) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(f, "�����hpֻ��Ϊ���֣�"); 
			return false;
		}
		return true;
		
	}
	
	
	/**
	 * ���hero�����ݿ⣬��������table������Դ
	 * @param hero
	 */
	public static void addHero(Hero hero) {
		//����DAO�����ڲ����¶���ͷ��ظ��º�������б�
		HeroDAO dao=new HeroDAO();
		
		dao.add(hero);
		//*****��������Tablemodel������ԴΪ�µ�list������Ҳ�͸�����table������
		heros.setList(dao.list());
		//��ʾ��ӳɹ�
		JOptionPane.showMessageDialog(f, "��ӳɹ���");
	}
	
	/**
	 * ����hero�����ݿ⣬��������table������Դ
	 * @param hero
	 */
	public static void updataHero(Hero hero) {
		//����DAO�����ڲ����¶���ͷ��ظ��º�������б�
		HeroDAO dao=new HeroDAO();
		
		dao.update(hero);
		//*****��������Tablemodel������ԴΪ�µ�list������Ҳ�͸�����table������
		heros.setList(dao.list());
		//��ʾ���³ɹ�
		JOptionPane.showMessageDialog(f, "���³ɹ���");
	}
	/**
	 * ����table������ʾ
	 * @param dialog
	 */
	public static void updataTable(JDialog dialog) {
	
		//ˢ��table��ʾ
		table.updateUI();
		
		//�ر�Jdialog
		dialog.setVisible(false);
	}
	
	
	/**
	 * AddDialog���������hero��Dialog
	 * @author Alice
	 *
	 */
	static class AddDialog extends JDialog{
		JLabel name=new JLabel("����:");
		JTextField namef=new JTextField();
		JLabel hp=new JLabel("Ѫ��:");
		JTextField hpf=new JTextField();
		JButton submitB=new JButton("�ύ");
		
		public AddDialog(JFrame f) {
			// TODO Auto-generated constructor stub
			super(f);
			name.setPreferredSize(new Dimension(100, 25));
			namef.setPreferredSize(new Dimension(150, 25));
			hp.setPreferredSize(new Dimension(100, 25));
			hpf.setPreferredSize(new Dimension(150, 25));
			this.add(name);
			this.add(namef);
			this.add(hp);
			this.add(hpf);
			this.add(submitB);
			this.setBounds(400, 300,300, 150);
			this.setModal(true);
			this.setLayout(new FlowLayout());
			
			submitB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String name=namef.getText();
					String hp=hpf.getText();
					
					/**
					 * �ж�����Ϸ���
					 */
					if(!legalJudge(name, hp))
						return;
					
					/**
					 * ���hero����
					 */
					double hpnum=Double.parseDouble(hp);
					Hero hero=new Hero(0, name, hpnum, 0.0);
					addHero(hero);
					
					/**
					 * ����table
					 */
					updataTable(AddDialog.this);
				}
			});
		}

	}
	
	/**
	 * ���ڱ༭hero��Dialog
	 * @author Alice
	 *
	 */
	static class EditDialog extends JDialog{
		JLabel name=new JLabel("����:");
		JTextField namef=new JTextField();
		JLabel hp=new JLabel("Ѫ��:");
		JTextField hpf=new JTextField();
		JButton submitB=new JButton("�ύ");
		
		public EditDialog(JFrame f) {
			// TODO Auto-generated constructor stub
			super(f);
			name.setPreferredSize(new Dimension(100, 25));
			namef.setPreferredSize(new Dimension(150, 25));
			hp.setPreferredSize(new Dimension(100, 25));
			hpf.setPreferredSize(new Dimension(150, 25));
			this.add(name);
			this.add(namef);
			this.add(hp);
			this.add(hpf);
			this.add(submitB);
			this.setBounds(400, 300,300, 150);
			this.setModal(true);
			this.setLayout(new FlowLayout());
			
			submitB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String name=namef.getText();
					String hp=hpf.getText();
					double hpnum=Double.parseDouble(hp);
					/**
					 * �ж�����Ϸ���
					 */
					if(!legalJudge(name, hp))
						return;
					
					/**
					 * ����hero����
					 */
					int row=table.getSelectedRow();
					int id=(int)heros.getValueAt(row, 0);
					Hero hero=new Hero(id, name, hpnum, 0.0);
					updataHero(hero);
					
					/**
					 * ����table
					 */
					updataTable(EditDialog.this);
					
					
				}
			});
			
		}
		public void setNamef(String name) {
			namef.setText(name);
		}
		
		public void setHpf(double hp ) {
			hpf.setText(String.valueOf(hp));
		}
		
		
	}
	
}
