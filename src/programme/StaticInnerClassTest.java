package programme;
/**
 * @version 2019/7/16
 * @author Administrator
 * Ѱ�������е�������Сֵ
 * ��һ���������޷���������ֵ������ʹ�÷���һ������min��max�Ķ���Pair
 * ��Pair�������ArrayAlg�ʹ�ô����࣬���õ��ĺͱ��Pair���ظ�
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
	 * ��̬�ڲ����޷������ⲿ��ķǾ�̬��������
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
