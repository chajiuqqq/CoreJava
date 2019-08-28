package Table;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class Ex6 {
	public static void main(String[] args) {
		JFrame f=new JFrame("table");
		f.setLocation(300, 200);
		f.setSize(400, 300);
		
		TableModel heros=new HeroTableModel();
		JTable table=new JTable(heros);
		JScrollPane sc=new JScrollPane(table);
		
		f.setLayout(new BorderLayout());
		
		f.add(sc);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}
