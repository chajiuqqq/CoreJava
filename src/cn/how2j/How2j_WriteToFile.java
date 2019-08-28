package cn.how2j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class How2j_WriteToFile {
	public static void main(String[] args) throws IOException {
		//file可以指向任何东西，如果文件的父级目录已经存在并且文件不存在，那会自动创建文件。
		//如果文件的父级目录不存在，直接这样写会报错：找不到路径
		//如果使用mkdirs()，记得先创建父级目录，不要带上文件名，不然也会被创建成文件夹
		File f=new File("D:/xyz/abc/def");
		f.mkdirs();
		
		//写入的时候一定是指向文件的，可以是还未创建的文件。
		FileOutputStream writer=new FileOutputStream("D:/xyz/abc/def/lol.txt");
		byte[] content={88,89};
		writer.write(content);
		writer.close();
	}
}	
