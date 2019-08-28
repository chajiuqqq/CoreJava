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
 * 设置了label，及时显示table中选中的条目信息
 * @author Alice
 * @version 2019年8月7日
 */
public class Ex7 {
	public static void main(String[] args) {
		JFrame f=new JFrame("table");
		f.setLocation(300, 200);
		f.setSize(400, 300);
		/**
		 * 设置label，放入Jpane中
		 */
		JLabel lab=new JLabel("当前选中的英雄是:");
		lab.setPreferredSize(new Dimension(200,30));
		JPanel pan=new JPanel();
		pan.add(lab);
		
		/**
		 * 设置table，从HeroTableModel中获取数据
		 * 做到设计和数据分离
		 */
		TableModel heros=new HeroTableModel();
		JTable table=new JTable(heros);
		JScrollPane sc=new JScrollPane(table);	//把table加入滚动面板中
		
		/**
		 * 设置两个面板的显示，这里用了边界布局
		 * lable设置北，table设置center
		 */
		f.setLayout(new BorderLayout());
		f.add(pan,BorderLayout.NORTH);
		f.add(sc,BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		/**
		 * 为table的选择模型(SelectionModel)添加列表选择监听器(ListSelectionListener)
		 */
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				//从table获取选中的行号
				int row =table.getSelectedRow();
				
				//从tablemodel里可以获得具体第几行第几列的数据，所以调用getValueAt(row, column)方法得到字段值
				String name=(String)heros.getValueAt(row, 1);
				
				lab.setText("当前选中的英雄是:"+name);
			}
		});
	}
}
