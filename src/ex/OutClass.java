package ex;
/*
 * 
	import ex.OutClass.InnerClass;
	
	public class test {    
		
		public static void main(String[] args) {
			OutClass aClass=new OutClass();
			InnerClass bClass=aClass.new InnerClass();
			System.out.println(bClass.b);
		}
	}
	
	内部类对别的类的可见性和普通类是一样的，可以通过import方式访问。
	如果是private修饰，那在外面无论如何都没法访问到了。
	
	唯一区别就是内部类和它的外围类是 我中有你你中有我，我们互通，private对各自都失效。
 */
public class OutClass {
	class InnerClass{
		private int a=0;
		public int b=1;
	}
}


