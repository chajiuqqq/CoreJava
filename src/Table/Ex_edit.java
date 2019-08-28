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
		 * 设置table属性
		 */
		
		//设置只能单选一行
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//这是默认选中第几行到第几行
		table.getSelectionModel().setSelectionInterval(0, 0);
		
		//把table加入滚动面板中
		JScrollPane sc=new JScrollPane(table);	
		
		
		
		/**
		 * 设置底部按钮区
		 */
		JPanel bottom=new JPanel();
		JButton addB=new JButton("添加");
		JButton delB=new JButton("删除");
		JButton editB=new JButton("编辑");
		
		bottom.add(addB);
		bottom.add(delB);
		bottom.add(editB);
		
		
		
		/**
		 * 设置两个面板的显示，这里用了边界布局
		 * panel设置北，table设置center
		 */
		f.setLayout(new BorderLayout());
		f.add(bottom,BorderLayout.SOUTH);
		f.add(sc,BorderLayout.NORTH);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
		
		/**
		 * 设置监听器
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
				
				int value=JOptionPane.showConfirmDialog(f, "确认删除吗？");
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
					JOptionPane.showMessageDialog(f, "请选择要编辑的英雄");
					return;
				}
				/**
				 * 获取选中行的名字和hp
				 */
				String name=(String)heros.getValueAt(selection, 1);
				double hp=(double)heros.getValueAt(selection, 2);
				/**
				 * 建立EditDialog 
				 */
				EditDialog dia=new EditDialog(f);
				dia.setNamef(name);
				dia.setHpf(hp);
				
				dia.setVisible(true);
			
			}
		});
	
	}
	/**
	 * 输入合法性判断
	 * @param name
	 * @param hp
	 * @return
	 */
	public static boolean legalJudge(String name,String hp) {
		/**
		 * 为空判断
		 */
		if("".equals(name)||"".equals(hp)){
			JOptionPane.showMessageDialog(f, "输入有空！"); 
			return false;
		}
		
		/**
		 * 验证hp合法
		 */
		try {
			double hpnum=Double.parseDouble(hp);
		} catch (NumberFormatException e1) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(f, "输入的hp只能为数字！"); 
			return false;
		}
		return true;
		
	}
	
	
	/**
	 * 添加hero到数据库，并更新了table的数据源
	 * @param hero
	 */
	public static void addHero(Hero hero) {
		//建立DAO，用于插入新对象和返回更新后的数据列表
		HeroDAO dao=new HeroDAO();
		
		dao.add(hero);
		//*****重新设置Tablemodel的数据源为新的list，这样也就更新了table的数据
		heros.setList(dao.list());
		//提示添加成功
		JOptionPane.showMessageDialog(f, "添加成功！");
	}
	
	/**
	 * 更新hero到数据库，并更新了table的数据源
	 * @param hero
	 */
	public static void updataHero(Hero hero) {
		//建立DAO，用于插入新对象和返回更新后的数据列表
		HeroDAO dao=new HeroDAO();
		
		dao.update(hero);
		//*****重新设置Tablemodel的数据源为新的list，这样也就更新了table的数据
		heros.setList(dao.list());
		//提示更新成功
		JOptionPane.showMessageDialog(f, "更新成功！");
	}
	/**
	 * 更新table数据显示
	 * @param dialog
	 */
	public static void updataTable(JDialog dialog) {
	
		//刷新table显示
		table.updateUI();
		
		//关闭Jdialog
		dialog.setVisible(false);
	}
	
	
	/**
	 * AddDialog，用于添加hero的Dialog
	 * @author Alice
	 *
	 */
	static class AddDialog extends JDialog{
		JLabel name=new JLabel("名称:");
		JTextField namef=new JTextField();
		JLabel hp=new JLabel("血量:");
		JTextField hpf=new JTextField();
		JButton submitB=new JButton("提交");
		
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
					 * 判断输入合法性
					 */
					if(!legalJudge(name, hp))
						return;
					
					/**
					 * 添加hero对象
					 */
					double hpnum=Double.parseDouble(hp);
					Hero hero=new Hero(0, name, hpnum, 0.0);
					addHero(hero);
					
					/**
					 * 更新table
					 */
					updataTable(AddDialog.this);
				}
			});
		}

	}
	
	/**
	 * 用于编辑hero的Dialog
	 * @author Alice
	 *
	 */
	static class EditDialog extends JDialog{
		JLabel name=new JLabel("名称:");
		JTextField namef=new JTextField();
		JLabel hp=new JLabel("血量:");
		JTextField hpf=new JTextField();
		JButton submitB=new JButton("提交");
		
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
					 * 判断输入合法性
					 */
					if(!legalJudge(name, hp))
						return;
					
					/**
					 * 更新hero对象
					 */
					int row=table.getSelectedRow();
					int id=(int)heros.getValueAt(row, 0);
					Hero hero=new Hero(id, name, hpnum, 0.0);
					updataHero(hero);
					
					/**
					 * 更新table
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
