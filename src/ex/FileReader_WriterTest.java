package ex;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * ����FileReader��FileWriter���test.txt���ж�д����
 * ��д������ݶ�������ӡ������̨ʱ��Ҫת��
 * @author Alice
 * @version 2019/7/19
 */
public class FileReader_WriterTest {
	public static void main(String[] args) throws IOException {
		File file=new File("test.txt");
		
		
		//д��
		FileWriter writer=new FileWriter(file);
		writer.write("this is an apple");
		writer.close();
		
		//��ȡ 
		FileReader reader=new FileReader(file);
		//�������̨ʱ����ISO-8859-1����ģ�ԭ����utf-8�����������룬�����ٱ��룬�ٰ�utf-8���������ȷ����
		StringBuilder myString=new StringBuilder();
		while(reader.ready()){
			myString.append((char)reader.read());
		}
		reader.close();
		
		String out=new String(myString.toString().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(out);
		
		
	}
}
