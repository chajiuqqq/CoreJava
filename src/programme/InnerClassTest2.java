package programme;

public class InnerClassTest2 {
	private double a=1.0;
	public int b=5;
	
	class eq{
		int c=0;
		public  eq(){
			//�ڲ����й��췽��
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
		//��static�ڲ��ഴ��ʵ��ʱ��Ҫ�ȴ�����Χ���ʵ��
		//test.eq lk=new test.eq();
		InnerClassTest2 in=new InnerClassTest2();
		InnerClassTest2.eq lk=in.new eq();
		
		//static�ڲ������ֱ�Ӵ���ʵ��
		InnerClassTest2.ch lj=new InnerClassTest2.ch();
	}
}
