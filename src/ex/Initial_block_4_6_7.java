package ex;

import java.util.Random;

public class Initial_block_4_6_7 {
		//声明变量
		private static int id;
		private int count;
		
		//初始化变量，static里的变量必须先声明了static
		static {
			//这个Random只为初始化而设立，所以作用域和生命只在这个代码块里
			Random aRandom=new Random();
			id=aRandom.nextInt(500);
		}
		
		//对变量没啥要求，对static的id也可以赋值
		{
			count=500;
			id=500;
		}
		//先运行构造器外的代码块，然后依次运行构造器里的内容，即使是有代码块也要按序运行
		public Initial_block_4_6_7() {
			id=100;
			{
				id=300;
			}	
		}
		public static void main(String[] args) {
			Initial_block_4_6_7 aBlock_4_6_7=new Initial_block_4_6_7();
			System.out.println("id: "+Initial_block_4_6_7.id);
			System.out.println("count: "+aBlock_4_6_7.count);
		}
}
