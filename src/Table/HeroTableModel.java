package Table;

import java.util.List;

import javax.swing.table.AbstractTableModel;


public class HeroTableModel extends AbstractTableModel {
	String[] columns={"id","name","hp","damage"};
	List<Hero> heros=null;
	public HeroTableModel() {
		// TODO Auto-generated constructor stub
		heros=new HeroDAO().list();
	}
	public HeroTableModel(int start,int count) {
		// TODO Auto-generated constructor stub
		heros=new HeroDAO().list(start, count);
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return heros.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}
	/**
	 * 重写获得列名的方法
	 */
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns[column];
	}
	/**
	 * 核心
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Hero hero=heros.get(rowIndex);
		if(columnIndex==0)
			return hero.getId();
		if(columnIndex==1)
			return hero.getName();
		if(columnIndex==2)
			return hero.getHp();
		if(columnIndex==3)
			return hero.getDamage();
		return null;
	}
	
	public void setList(List<Hero> newlist) {
		heros=newlist;
	}

}
