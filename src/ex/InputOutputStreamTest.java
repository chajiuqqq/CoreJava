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
 * 利用FileOutputStream和FileInputStream对test.txt进行读写
 * 为了防止乱码，这里采用了 OutputStreamWriter和 InputStreamWriter对读写的编码进行控制
 * 最后通过StringBuffer合并字符串并打印写入的内容
 * @author Alice
 * @version 2019年7月19日
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
