package programme;

import programme.Pair;
/**
 * 测试了：
 * 子类型通配符限定
 * 超类型通配符限定
 * 通配符捕获
 * @author Alice
 * @version 2019年7月22日
 */
public class PairTest3_8_3 {
	public static void main(String[] args) {
		Manager ceo=new Manager("Tom", 800000, 2003, 10, 2);
		Manager cfo=new Manager("MONO", 150000, 1985, 1, 2);
		Manager coo=new Manager("Jack", 650000, 1998, 12, 6);
		Pair<Manager> buddies=new Pair<Manager>(ceo, cfo);
		System.out.println("打印ceo，cfo：");
		printBuddies(buddies);
		
		ceo.setBonus(500000);
		cfo.setBonus(300000);
		
		Manager[] managers={ceo,cfo,coo};
		Pair<Employee> result=new Pair<Employee>();
		minmaxBonus(managers, result);
		System.out.println("排序后（minmax）：");
		printBuddies(result);
		System.out.println("排序后（maxmin）：");
		maxminBonus(managers, result);
		printBuddies(result);
	}
	/**
	 * 打印给定Pair对象里的两个人名
	 * 用到访问方法，所以需要子类型限定
	 * @param p
	 */
	public static void printBuddies(Pair<? extends Employee> p) {
		Employee aEmployee=p.getFirst();
		Employee bEmployee=p.getSecond();
		System.out.println("firstName: "+aEmployee.getName());
		System.out.println("secondName: "+bEmployee.getName());
	}
	
	/**
	 * 对传入的数组，求其薪水min和max，并存放在传入的Pair对中(可以放到Employee的超类型Pair中，而且要用到set方法，就用超类型限定)
	 * @param a 传入的Employee数组
	 * @param result 结果存放Pair对象
	 */
	public static void minmaxBonus(Employee[] a,Pair<? super Employee> result) {
		if(a.length==0)
			return;
		Employee min=a[0];
		Employee max=a[0];
		
		for(int i=0;i<a.length;i++){
			if(a[i].compareTo(max)>0)
				max=a[i];
			if(a[i].compareTo(min)<0)
				min=a[i];
		}
		
		result.setFirst(min);
		result.setSecond(max);
	}
	
	/**
	 *  对传入的数组，求其薪水min和max，并逆序存放在传入的Pair对中
	 * @param a
	 * @param result
	 */
	public static void maxminBonus(Employee[] a,Pair<? super Employee> result){
		minmaxBonus(a, result);
		PairAlg.swap(result);
	}
}

/**
 * 通配符的捕获方法
 * @author Alice
 *
 */
class PairAlg{
	public static void swap(Pair<?> p) {
		swapHelper(p);
	}
	
	private static <T> void swapHelper(Pair<T> p) {
		T temp=p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(temp);
	}
}
