package ex;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 利用FileReader和FileWriter类对test.txt进行读写操作
 * 将写入的数据读出并打印至控制台时需要转码
 * @author Alice
 * @version 2019/7/19
 */
public class FileReader_WriterTest {
	public static void main(String[] args) throws IOException {
		File file=new File("test.txt");
		
		
		//写入
		FileWriter writer=new FileWriter(file);
		writer.write("this is an apple");
		writer.close();
		
		//读取 
		FileReader reader=new FileReader(file);
		//读入控制台时按照ISO-8859-1解码的，原来是utf-8，所以是乱码，这里再编码，再按utf-8解码就是正确的了
		StringBuilder myString=new StringBuilder();
		while(reader.ready()){
			myString.append((char)reader.read());
		}
		reader.close();
		
		String out=new String(myString.toString().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(out);
		
		
	}
}
