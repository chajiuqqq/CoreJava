package cn.how2j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class How2j_WriteToFile {
	public static void main(String[] args) throws IOException {
		//file����ָ���κζ���������ļ��ĸ���Ŀ¼�Ѿ����ڲ����ļ������ڣ��ǻ��Զ������ļ���
		//����ļ��ĸ���Ŀ¼�����ڣ�ֱ������д�ᱨ���Ҳ���·��
		//���ʹ��mkdirs()���ǵ��ȴ�������Ŀ¼����Ҫ�����ļ�������ȻҲ�ᱻ�������ļ���
		File f=new File("D:/xyz/abc/def");
		f.mkdirs();
		
		//д���ʱ��һ����ָ���ļ��ģ������ǻ�δ�������ļ���
		FileOutputStream writer=new FileOutputStream("D:/xyz/abc/def/lol.txt");
		byte[] content={88,89};
		writer.write(content);
		writer.close();
	}
}	
