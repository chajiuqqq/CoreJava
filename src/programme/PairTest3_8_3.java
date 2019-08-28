package programme;

import programme.Pair;
/**
 * �����ˣ�
 * ������ͨ����޶�
 * ������ͨ����޶�
 * ͨ�������
 * @author Alice
 * @version 2019��7��22��
 */
public class PairTest3_8_3 {
	public static void main(String[] args) {
		Manager ceo=new Manager("Tom", 800000, 2003, 10, 2);
		Manager cfo=new Manager("MONO", 150000, 1985, 1, 2);
		Manager coo=new Manager("Jack", 650000, 1998, 12, 6);
		Pair<Manager> buddies=new Pair<Manager>(ceo, cfo);
		System.out.println("��ӡceo��cfo��");
		printBuddies(buddies);
		
		ceo.setBonus(500000);
		cfo.setBonus(300000);
		
		Manager[] managers={ceo,cfo,coo};
		Pair<Employee> result=new Pair<Employee>();
		minmaxBonus(managers, result);
		System.out.println("�����minmax����");
		printBuddies(result);
		System.out.println("�����maxmin����");
		maxminBonus(managers, result);
		printBuddies(result);
	}
	/**
	 * ��ӡ����Pair���������������
	 * �õ����ʷ�����������Ҫ�������޶�
	 * @param p
	 */
	public static void printBuddies(Pair<? extends Employee> p) {
		Employee aEmployee=p.getFirst();
		Employee bEmployee=p.getSecond();
		System.out.println("firstName: "+aEmployee.getName());
		System.out.println("secondName: "+bEmployee.getName());
	}
	
	/**
	 * �Դ�������飬����нˮmin��max��������ڴ����Pair����(���Էŵ�Employee�ĳ�����Pair�У�����Ҫ�õ�set���������ó������޶�)
	 * @param a �����Employee����
	 * @param result ������Pair����
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
	 *  �Դ�������飬����нˮmin��max�����������ڴ����Pair����
	 * @param a
	 * @param result
	 */
	public static void maxminBonus(Employee[] a,Pair<? super Employee> result){
		minmaxBonus(a, result);
		PairAlg.swap(result);
	}
}

/**
 * ͨ����Ĳ��񷽷�
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
