package programme;

class jk{
	String as="as";
	static int m=0;
	/**
	 * �ֲ��ڲ����Ƿ���Է���/�޸��ⲿ�����/�ֲ�����?
	 * @param i
	 * @param x
	 */
	public void tank(int i,String x) {
		class mk{
			public void visit() {
				//���Է����ⲿ��ı���
				System.out.println(as);
				int a=m;
				//Ҳ���Ըı���
				as="dd";
				
				
				
				//�ֲ�������final�ģ��޷��ı�
				//Local variable i defined in an enclosing scope must be final or effectively final
				//error: i++;
				
				//�ı�ԭ��String���������ָ��Ҳ�ǲ��е�
				//error x=x.toLowerCase();
			}
		}	
	}
}
public class EnclosdInnerClassTest {

}
