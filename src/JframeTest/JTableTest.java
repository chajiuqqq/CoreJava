package JframeTest;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest {

	public static void main(String[] args) {
		JFrame f=new JFrame("���±�");
		f.setLocation(200, 200);
		f.setSize(400, 300);
		
		 // ����ϵ�title
        String[] columnNames = new String[] { "id", "name", "hp", "damage" };
        // ����е����ݣ���һ����ά����
        String[][] heros = new String[][] { { "1", "����", "616", "100" },
                { "2", "��Ī", "512", "102" }, { "3", "����", "832", "200" } };
                
        JTable table=new JTable(heros, columnNames);
        
        JScrollPane sp=new JScrollPane(table);
        // �����п��	
        table.getColumnModel().getColumn(0).setPreferredWidth(10);	
        
        
        f.add(sp);
                
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
}
