package JframeTest;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest {

	public static void main(String[] args) {
		JFrame f=new JFrame("记事本");
		f.setLocation(200, 200);
		f.setSize(400, 300);
		
		 // 表格上的title
        String[] columnNames = new String[] { "id", "name", "hp", "damage" };
        // 表格中的内容，是一个二维数组
        String[][] heros = new String[][] { { "1", "盖伦", "616", "100" },
                { "2", "提莫", "512", "102" }, { "3", "奎因", "832", "200" } };
                
        JTable table=new JTable(heros, columnNames);
        
        JScrollPane sp=new JScrollPane(table);
        // 设置列宽度	
        table.getColumnModel().getColumn(0).setPreferredWidth(10);	
        
        
        f.add(sp);
                
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
}
