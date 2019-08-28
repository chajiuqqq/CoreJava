package programme;

class jk{
	String as="as";
	static int m=0;
	/**
	 * 局部内部类是否可以访问/修改外部类变量/局部变量?
	 * @param i
	 * @param x
	 */
	public void tank(int i,String x) {
		class mk{
			public void visit() {
				//可以访问外部类的变量
				System.out.println(as);
				int a=m;
				//也可以改变它
				as="dd";
				
				
				
				//局部变量是final的，无法改变
				//Local variable i defined in an enclosing scope must be final or effectively final
				//error: i++;
				
				//改变原来String对象变量的指向也是不行的
				//error x=x.toLowerCase();
			}
		}	
	}
}
public class EnclosdInnerClassTest {

}
