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
 * 更新table
 * @author Alice
 * @version 2019年8月8日
 */
public class Ex8 {
	public static void main(String[] args) {
		JFrame f=new JFrame("table");
		f.setLocation(300, 200);
		f.setSize(400, 300);
		/**
		 * 设置panel
		 */
		JLabel name=new JLabel("名称:");
		JTextField namef=new JTextField();
		namef.setPreferredSize(new Dimension(100, 25));
		
		JLabel hp=new JLabel("血量:");
		JTextField hpf=new JTextField();
		hpf.setPreferredSize(new Dimension(100, 25));
		
		JButton addB=new JButton("增加");
		
		JPanel pan=new JPanel();
		pan.add(name);
		pan.add(namef);
		pan.add(hp);
		pan.add(hpf);
		pan.add(addB);
		/**
		 * 设置table，从HeroTableModel中获取数据
		 * 做到设计和数据分离
		 */
		HeroTableModel heros=new HeroTableModel();
		JTable table=new JTable(heros);
		
		//设置只能单选一行
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//这是默认选中第几行到第几行
		table.getSelectionModel().setSelectionInterval(0, 0);
		
		//把table加入滚动面板中
		JScrollPane sc=new JScrollPane(table);	
		
		/**
		 * 设置两个面板的显示，这里用了边界布局
		 * panel设置北，table设置center
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
				 * 为空判断
				 */
				if("".equals(name)||"".equals(hp)){
					JOptionPane.showMessageDialog(f, "输入有空！"); 
					return;
				}
				
				/**
				 * 验证hp合法
				 */
				try {
					hpnum=Double.parseDouble(hp);
				} catch (NumberFormatException e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(f, "输入的hp只能为数字！"); 
					return;
				}
				
				
				//创建新的hero对象
				Hero hero=new Hero(0, name, hpnum, 0.0);
				
				//建立DAO，用于插入新对象和返回更新后的数据列表
				HeroDAO dao=new HeroDAO();
				dao.add(hero);
				
				//重新设置Tablemodel的数据源为新的list，这样也就更新了table的数据
				heros.setList(dao.list());
				
				//刷新table显示
				table.updateUI();
				
				
			}
		});
	}
	
	
}
