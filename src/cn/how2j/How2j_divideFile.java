package cn.how2j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class How2j_divideFile {
	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\Alice\\Pictures\\Saved Pictures\\zyy.png");
		FileInputStream reader=new FileInputStream(f);
		byte[] b=new byte[(int)f.length()];
		reader.read(b);
		
		reader.close();
		
		FileOutputStream writer=null;
		
		int num=(int)f.length()/(100*1024);
		
		for(int i=0;i<num+1;i++){
			writer=new FileOutputStream(new File("C:\\Users\\Alice\\Pictures\\Saved Pictures\\zyyout",i+" zyy.png"));
			if(i!=num)	
				writer.write(b, i*100*1024, 100*1024);
			if(i==num)
				writer.write(b, num*100*1024, (int)f.length()-num*100*1024);
		}
		
		writer.close();
		System.out.println("successful!");
		
		
		
	}
}
