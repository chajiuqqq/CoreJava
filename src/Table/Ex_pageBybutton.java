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
/**
 * ��ϰ-ʹ�ð�ť��ҳ
 * ��table�н�����ʾ10�����ݡ�
         ���·�����4����ť
         ��ҳ ��һҳ ��һҳ ĩҳ
 * @author Alice
 * @version  2019��8��8�� ���⣺�༭����ť��������table��ʾȫ����Ϣ����Ҫ�޸ı༭����ť�Ĵ�����
 * 			2019��8��9��  �ѽ����ʹ��showPage���ֱ����ÿ�ʼindex����
 */
public class Ex_pageBybutton {
	static JFrame f=new JFrame("table");
	static int pageIndex=1;
	static int showItemNumber=10;
	static HeroTableModel heros=new HeroTableModel(0,showItemNumber);
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
		
		JPanel editPanel=new JPanel();
		JPanel showPanel=new JPanel();
		
		JButton addB=new JButton("���");
		JButton delB=new JButton("ɾ��");
		JButton editB=new JButton("�༭");
		
		JButton firstPageB=new JButton("��ҳ");
		JButton formerPageB=new JButton("��һҳ");
		JButton nextPageB=new JButton("��һҳ");
		JButton lastPageB=new JButton("ĩҳ");
		
		editPanel.add(addB);
		editPanel.add(delB);
		editPanel.add(editB);
		
		showPanel.add(firstPageB);
		showPanel.add(formerPageB);
		showPanel.add(nextPageB);
		showPanel.add(lastPageB);
		
		bottom.setLayout(new BorderLayout());
		bottom.add(editPanel,BorderLayout.NORTH);
		bottom.add(showPanel,BorderLayout.SOUTH);
		
		
		/**
		 * ��������������ʾ���������˱߽粼��
		 * panel���ñ���table����center
		 */
		f.setLayout(new BorderLayout());
		
		f.add(sc,BorderLayout.CENTER);
		f.add(bottom,BorderLayout.SOUTH);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		/**
		 * ʹ���̼߳��ҳ�������Ʒ�ҳ��ť�Ƿ����
		 */
		Thread t=new Thread(){
			@Override
			public void run() {
				int pageCount=getPageCount(showItemNumber);
				while(true){
					if(pageIndex==1){
						firstPageB.setEnabled(false);
						formerPageB.setEnabled(false);	
						nextPageB.setEnabled(true);
						lastPageB.setEnabled(true);
					}
					if(pageIndex==pageCount){
						nextPageB.setEnabled(false);
						lastPageB.setEnabled(false);
						firstPageB.setEnabled(true);
						formerPageB.setEnabled(true);
					}
					
					if(pageIndex>1&&pageIndex<pageCount){
						nextPageB.setEnabled(true);
						lastPageB.setEnabled(true);
						firstPageB.setEnabled(true);
						formerPageB.setEnabled(true);
						
					}
					
					
					
				}
			}
		};
		t.start();
		
		/**
		 * ���ü�����
		 */
		
		//��Ӱ�ť
		addB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddDialog dia=new AddDialog(f);
				dia.setVisible(true);
			
			}
		});
		
		//ɾ����ť
		delB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//���ɾ����Ŀ��id
				int row=table.getSelectedRow();
				int delId=(int)heros.getValueAt(row, 0);
				HeroDAO dao=new HeroDAO();
				
				int value=JOptionPane.showConfirmDialog(f, "ȷ��ɾ����");
				if(value==JOptionPane.YES_OPTION){
					dao.delete(delId);
					
					//���ɾ������Ŀ�����һҳ�ĵ�һ������ɾ����pageIndexӦ��һ
					int total=getTableSize();
					if(total%showItemNumber==0)
						pageIndex-=1;

					showPage((pageIndex-1)*showItemNumber,showItemNumber);
					
				}
			}
		});
		
		//�༭��ť
		editB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��δѡ������ʾ
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
				//�ı���Ĭ������Ϊѡ�е���Ŀ����
				dia.setNamef(name);
				dia.setHpf(hp);
				
				dia.setVisible(true);
			
			}
		});
		
		//��һҳ��ť
		firstPageB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ÿ�ΰ�����ҳʱ��pageIndex��Ӧ��Ϊ1
				pageIndex=1;
				showPage(0, 10);
			}
		});
		//��һҳ��ť
		nextPageB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pageIndex++;
				int start=(pageIndex-1)*showItemNumber;
				showPage(start, showItemNumber);
			}
		});
		//��һҳ��ť
		formerPageB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pageIndex--;
				int start=(pageIndex-1)*showItemNumber;
				showPage(start, showItemNumber);
			}
		});
		
		//ĩҳ��ť
		lastPageB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pageIndex=getPageCount(showItemNumber);
				showPage((pageIndex-1)*showItemNumber, showItemNumber);
			}
		});
	
	}
	
	//=========================��̬������===============================
	
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
	 * ���hero�����ݿ⣬������table��ʾ��һҳ������
	 * @param hero
	 */
	public static void addHero(Hero hero) {
		//����DAO�����ڲ����¶���ͷ��ظ��º�������б�
		HeroDAO dao=new HeroDAO();
		
		dao.add(hero);
		pageIndex=1;
		
		showPage(0, showItemNumber);
		//ѡ�иո���ӵ���Ŀ
		table.setRowSelectionInterval(0, 0);
		//��ʾ��ӳɹ�
		JOptionPane.showMessageDialog(f, "��ӳɹ���");
	}
	
	/**
	 * ����hero�����ݿ⣬��������tableҪ��ʾ��ҳ����
	 * @param hero
	 */
	public static void updataHero(Hero hero) {
		//����DAO�����ڲ����¶���ͷ��ظ��º�������б�
		HeroDAO dao=new HeroDAO();
		
		dao.update(hero);
		
		int startShowIndex=(pageIndex-1)*showItemNumber;
		showPage(startShowIndex, showItemNumber);
		//��ʾ���³ɹ�
		JOptionPane.showMessageDialog(f, "���³ɹ���");
	}
	
	/**
	 * ���÷�ҳ��ʾ�Ĳ���
	 * @param start	��ʼ��Ŀ�ı��
	 * @param count	��ʾ��Ŀ��
	 */
	public static void showPage(int start,int count) {
		HeroDAO heroDAO=new HeroDAO();
		heros.setList(heroDAO.list(start, count));
		table.updateUI();
	}
	/**
	 * �õ��������ݿ����Ŀ��
	 * @return
	 */
	public static int getTableSize() {
		HeroDAO heroDAO=new HeroDAO();
		return heroDAO.list().size();
	}
	
	/**
	 * �õ���ǰ���ݿ���Ŀ��showedItemNumber��ҳ��ʾʱ����ҳ��
	 * @param showedItemNumber	ÿҳ��ʾ��Ŀ��
	 * @return
	 */
	public static int getPageCount(int showedItemNumber) {
		return getTableSize()/showedItemNumber+((getTableSize()%showedItemNumber==0)?0:1);
	}
	
	//==============================����Dialog�����=======================
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
			
			//�ύ��ť
			submitB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String name=namef.getText();
					String hp=hpf.getText();
					double hpnum=Double.parseDouble(hp);
					
					// �ж�����Ϸ���
					if(!legalJudge(name, hp))
						return;

					// ���hero����
					Hero hero=new Hero(0, name, hpnum, 0.0);
					addHero(hero);

					//�ر�Jdialog
					AddDialog.this.setVisible(false);
					
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
			
			//�ύ��ť
			submitB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String name=namef.getText();
					String hp=hpf.getText();
					double hpnum=Double.parseDouble(hp);
					
					// �ж�����Ϸ���
					if(!legalJudge(name, hp))
						return;
				
					// ����hero����
					int row=table.getSelectedRow();
					int id=(int)heros.getValueAt(row, 0);
					Hero hero=new Hero(id, name, hpnum, 0.0);
					updataHero(hero);
					
					EditDialog.this.setVisible(false);
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
