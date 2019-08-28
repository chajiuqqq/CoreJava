package programme;
/**
 * @version 2019/7/16
 * @author Administrator
 * 寻找数组中的最大和最小值
 * 在一个方法里无法返回两个值，所以使用返回一个包含min和max的对象Pair
 * 该Pair类包含在ArrayAlg里，使得代码简洁，不用担心和别的Pair类重复
 */
class ArrayAlg{
	String as="as";
	static int m=0;
	
	public static Pair minmax(int[] list) {
		int min=list[0];
		int max=list[0];
		for(int x:list){
			min=x<min?x:min;
			max=x>max?x:max;
		}
		return new Pair(min,max);
	}
	static class Pair{
		int min=0;
		int max=0;
		public Pair(int min,int max){
			this.max=max;
			this.min=min;
		}
		public int getMin() {
			return min;
		}
		public int getMax() {
			return max;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "min: "+min +"\nmax: "+max;
		}
	}

	/**
	 * 静态内部类无法引用外部类的非静态方法和域
	 * @author Administrator
	 *
	 */
	static class lk{
		int k=m;
		//error: String ss=as;
		public void f1() {
			Math.pow(2, 3);
		}
	}
}

public class StaticInnerClassTest {
	public static void main(String[] args) {
		int[] list={1,15,20,2,46,95,120,12,30,31};
		ArrayAlg.Pair myPair=ArrayAlg.minmax(list);
		System.out.println(myPair);
	}
}
