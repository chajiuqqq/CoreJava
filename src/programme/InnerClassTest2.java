package programme;

public class InnerClassTest2 {
	private double a=1.0;
	public int b=5;
	
	class eq{
		int c=0;
		public  eq(){
			//内部类有构造方法
		}
		public void f1() {
			System.out.println(a);
		}
		public void f2() {
			System.out.println(b);
		}
	}
	
	static class ch{
		public void f3() {
			//System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		//非static内部类创建实例时需要先创建外围类的实例
		//test.eq lk=new test.eq();
		InnerClassTest2 in=new InnerClassTest2();
		InnerClassTest2.eq lk=in.new eq();
		
		//static内部类可以直接创建实例
		InnerClassTest2.ch lj=new InnerClassTest2.ch();
	}
}
