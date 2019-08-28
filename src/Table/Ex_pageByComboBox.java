package Table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
 * 练习-使用下拉框分页
 * 借助下拉框实现下拉框分页
 * @author Alice
 * @version  2019年8月9日
 * 遇到的问题：
 * 1.combobox对条目的选择，影响pageIndex和表格显示的条目
 * 2.添加/删除/翻页区按钮的操作都会影响comboBox当前选择的条目
 * 3.添加/删除会导致menu内容有增/减，需要重新设置comboBox的数据源
 * 			
 */
public class Ex_pageByComboBox {
	static JFrame f=new JFrame("AdvancedTable");
	static int pageIndex=1;
	static int showItemNumber=10;
	static HeroTableModel heros=new HeroTableModel(0,showItemNumber);
	static JTable table=new JTable(heros);
	static Integer[] pagesMenu=atuoAssignMenu();
	static JComboBox<Integer> menuBox;
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
		
		JPanel editPanel=new JPanel();
		JPanel showPanel=new JPanel();
		
		JButton addB=new JButton("添加");
		JButton delB=new JButton("删除");
		JButton editB=new JButton("编辑");
		
		JButton firstPageB=new JButton("首页");
		JButton formerPageB=new JButton("上一页");
		
		menuBox=new JComboBox<>(pagesMenu);
		
		JButton nextPageB=new JButton("下一页");
		JButton lastPageB=new JButton("末页");
		
		editPanel.add(addB);
		editPanel.add(delB);
		editPanel.add(editB);
		
		showPanel.add(firstPageB);
		showPanel.add(formerPageB);
		showPanel.add(menuBox);
		showPanel.add(nextPageB);
		showPanel.add(lastPageB);
		
		bottom.setLayout(new BorderLayout());
		bottom.add(editPanel,BorderLayout.NORTH);
		bottom.add(showPanel,BorderLayout.SOUTH);
		
		
		/**
		 * 设置两个面板的显示，这里用了边界布局
		 * panel设置北，table设置center
		 */
		f.setLayout(new BorderLayout());
		
		f.add(sc,BorderLayout.CENTER);
		f.add(bottom,BorderLayout.SOUTH);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		/**
		 * 使用线程监控页数，控制翻页按钮是否可用
		 */
		Thread t=new Thread(){
			@Override
			public void run() {
				while(true){
					int pageCount=getPageCount(showItemNumber);
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
					
					try {
						Thread.sleep(200);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
					
					
				}
			}
		};
		t.start();
		
		/**
		 * 设置监听器==========================================
		 */
		
		//添加按钮
		addB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddDialog dia=new AddDialog(f);
				dia.setVisible(true);
			
			}
		});
		
		//删除按钮
		delB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获得删除条目的id
				int row=table.getSelectedRow();
				int delId=(int)heros.getValueAt(row, 0);
				HeroDAO dao=new HeroDAO();
				
				int value=JOptionPane.showConfirmDialog(f, "确认删除吗？");
				if(value==JOptionPane.YES_OPTION){
					dao.delete(delId);
					
					//如果删除的条目是最后一页的第一个，则删除后pageIndex应减一
					int total=getTableSize();
					if(total%showItemNumber==0)
						pageIndex-=1;

					showPage((pageIndex-1)*showItemNumber,showItemNumber);
					
					//添加可能导致页数变化，所以重新设置menu的条目来源
					pagesMenu=atuoAssignMenu();
					menuBox.setModel(new DefaultComboBoxModel<>(pagesMenu));
					
					menuBox.setSelectedIndex(pageIndex-1);
				}
			}
		});
		
		//编辑按钮
		editB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 若未选中则提示
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
				//文本框默认内容为选中的条目内容
				dia.setNamef(name);
				dia.setHpf(hp);
				
				dia.setVisible(true);
			
			}
		});
		
		//第一页按钮
		firstPageB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 每次按下首页时，pageIndex都应设为1
				pageIndex=1;
				showPage(0, 10);
				menuBox.setSelectedIndex(pageIndex-1);
				
			}
		});
		//下一页按钮
		nextPageB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pageIndex++;
				int start=(pageIndex-1)*showItemNumber;
				showPage(start, showItemNumber);
				menuBox.setSelectedIndex(pageIndex-1);
			}
		});
		//上一页按钮
		formerPageB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pageIndex--;
				int start=(pageIndex-1)*showItemNumber;
				showPage(start, showItemNumber);
				menuBox.setSelectedIndex(pageIndex-1);
			}
		});
		
		//末页按钮
		lastPageB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pageIndex=getPageCount(showItemNumber);
				showPage((pageIndex-1)*showItemNumber, showItemNumber);
				menuBox.setSelectedIndex(pageIndex-1);
			}
		});
		
		//下拉菜单
		menuBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				pageIndex=(int)menuBox.getSelectedItem();
				showPage((pageIndex-1)*showItemNumber, showItemNumber);
			}
		});
		
	}
	
	//=========================静态方法区===============================
	
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
	 * 添加hero到数据库，并更新table显示第一页的内容
	 * @param hero
	 */
	public static void addHero(Hero hero) {
		//建立DAO，用于插入新对象和返回更新后的数据列表
		HeroDAO dao=new HeroDAO();
		
		dao.add(hero);
		
		pageIndex=1;	//添加在最前面，所以pageIndex设应为1
		
		//添加可能导致页数变化，所以重新设置menu的条目来源
		pagesMenu=atuoAssignMenu();
		//menuBox.updateUI();这个无效
		menuBox.setModel(new DefaultComboBoxModel<>(pagesMenu));
	
		
		menuBox.setSelectedIndex(0);	//pageIndex变化了，menu也要变
		
		showPage(0, showItemNumber);
		//选中刚刚添加的条目
		table.setRowSelectionInterval(0, 0);
		//提示添加成功
		JOptionPane.showMessageDialog(f, "添加成功！");
	}
	
	/**
	 * 更新hero到数据库，并更新了table要显示的页内容
	 * @param hero
	 */
	public static void updataHero(Hero hero) {
		//建立DAO，用于插入新对象和返回更新后的数据列表
		HeroDAO dao=new HeroDAO();
		
		dao.update(hero);
		
		int startShowIndex=(pageIndex-1)*showItemNumber;
		showPage(startShowIndex, showItemNumber);
		//提示更新成功
		JOptionPane.showMessageDialog(f, "更新成功！");
	}
	
	/**
	 * 设置分页显示的操作
	 * @param start	开始条目的编号
	 * @param count	显示条目数
	 */
	public static void showPage(int start,int count) {
		HeroDAO heroDAO=new HeroDAO();
		heros.setList(heroDAO.list(start, count));
		table.updateUI();
	}
	/**
	 * 得到最新数据库的条目数
	 * @return
	 */
	public static int getTableSize() {
		HeroDAO heroDAO=new HeroDAO();
		return heroDAO.list().size();
	}
	
	/**
	 * 得到当前数据库条目按showedItemNumber分页显示时的总页数
	 * @param showedItemNumber	每页显示条目数
	 * @return
	 */
	public static int getPageCount(int showedItemNumber) {
		return getTableSize()/showedItemNumber+((getTableSize()%showedItemNumber==0)?0:1);
	}
	/**
	 * 自动设置目录字符串数组
	 * @return
	 */
	public static Integer[] atuoAssignMenu() {
		int pages=getPageCount(showItemNumber);
		Integer[] menu=new Integer[pages];
		for(int i=1;i<=pages;i++){
			menu[i-1]=i;
		}
		return menu;
	}
	
	//==============================两个Dialog面板类=======================
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
			
			//提交按钮
			submitB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String name=namef.getText();
					String hp=hpf.getText();
					double hpnum=Double.parseDouble(hp);
					
					// 判断输入合法性
					if(!legalJudge(name, hp))
						return;

					// 添加hero对象
					Hero hero=new Hero(0, name, hpnum, 0.0);
					addHero(hero);
					
					
					//关闭Jdialog
					AddDialog.this.setVisible(false);
					
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
			
			//提交按钮
			submitB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String name=namef.getText();
					String hp=hpf.getText();
					double hpnum=Double.parseDouble(hp);
					
					// 判断输入合法性
					if(!legalJudge(name, hp))
						return;
				
					// 更新hero对象
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
