package ex;

import java.io.File;
import java.io.IOException;

/**
 * ���������ļ������鿴��Ȼ��ɾ��
 * @author Alice
 *
 */
public class TestFile2 {
	public static void main(String[] args) throws IOException {
		File root=new File("myroot");
		root.mkdir();
		String filename;
		//����20��doc�ļ�
		for(int i=0;i<20;i++){
			int ch=i+'A';
			filename=(char)ch+" File.doc";
			File myFile=new File(root,filename);
			myFile.createNewFile();
		}
		
		
		//���ɾ��10��
		for(int i=0;i<10;i++){
			int delnum=(int)(Math.random()*10)+'A';
			File delfile=new File(root,(char)delnum+" File.doc");
			delfile.delete();
		}
		
		//��ӡʣ�µ��ļ�
		String[] allfilename=root.list();
		for(String x:allfilename){
			System.out.println(x);
		}
		
	}
}
