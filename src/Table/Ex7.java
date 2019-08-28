package Table;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

/**
 * ������label����ʱ��ʾtable��ѡ�е���Ŀ��Ϣ
 * @author Alice
 * @version 2019��8��7��
 */
public class Ex7 {
	public static void main(String[] args) {
		JFrame f=new JFrame("table");
		f.setLocation(300, 200);
		f.setSize(400, 300);
		/**
		 * ����label������Jpane��
		 */
		JLabel lab=new JLabel("��ǰѡ�е�Ӣ����:");
		lab.setPreferredSize(new Dimension(200,30));
		JPanel pan=new JPanel();
		pan.add(lab);
		
		/**
		 * ����table����HeroTableModel�л�ȡ����
		 * ������ƺ����ݷ���
		 */
		TableModel heros=new HeroTableModel();
		JTable table=new JTable(heros);
		JScrollPane sc=new JScrollPane(table);	//��table������������
		
		/**
		 * ��������������ʾ���������˱߽粼��
		 * lable���ñ���table����center
		 */
		f.setLayout(new BorderLayout());
		f.add(pan,BorderLayout.NORTH);
		f.add(sc,BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		/**
		 * Ϊtable��ѡ��ģ��(SelectionModel)����б�ѡ�������(ListSelectionListener)
		 */
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				//��table��ȡѡ�е��к�
				int row =table.getSelectedRow();
				
				//��tablemodel����Ի�þ���ڼ��еڼ��е����ݣ����Ե���getValueAt(row, column)�����õ��ֶ�ֵ
				String name=(String)heros.getValueAt(row, 1);
				
				lab.setText("��ǰѡ�е�Ӣ����:"+name);
			}
		});
	}
}
