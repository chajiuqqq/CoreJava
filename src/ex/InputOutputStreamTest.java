package ex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
/**
 * ����FileOutputStream��FileInputStream��test.txt���ж�д
 * Ϊ�˷�ֹ���룬��������� OutputStreamWriter�� InputStreamWriter�Զ�д�ı�����п���
 * ���ͨ��StringBuffer�ϲ��ַ�������ӡд�������
 * @author Alice
 * @version 2019��7��19��
 *
 */
public class InputOutputStreamTest {
	public static void main(String[] args)  {
		String path="test.txt";
		try(OutputStream fo=new FileOutputStream(path);
				InputStream fi=new FileInputStream(path);
				OutputStreamWriter writer=new OutputStreamWriter(fo, "UTF-8");
				InputStreamReader reader=new InputStreamReader(fi,"UTF-8");){
			
			writer.append((char)56);
			writer.append('c');
			writer.append(" English");
			StringBuffer buffer=new StringBuffer();
			while(reader.ready()){
				buffer.append((char)reader.read());
			}
			System.out.println(buffer.toString());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
