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
	
	�ڲ���Ա����Ŀɼ��Ժ���ͨ����һ���ģ�����ͨ��import��ʽ���ʡ�
	�����private���Σ���������������ζ�û�����ʵ��ˡ�
	
	Ψһ��������ڲ����������Χ���� ���������������ң����ǻ�ͨ��private�Ը��Զ�ʧЧ��
 */
public class OutClass {
	class InnerClass{
		private int a=0;
		public int b=1;
	}
}


