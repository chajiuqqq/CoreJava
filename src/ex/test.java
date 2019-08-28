package ex;

import java.io.File;

public class test {   
	public static void main(String[] args) {
		File f=new File("E:/project/CoreJava/src/ex/Array_3_10_2.java");
		File[] aFiles=f.listFiles();
		for(File x:aFiles)
			System.out.println(x);
	}
}
