package programme;

public interface Power extends Moveable {
	static double milesPerGallon() {
		return SPEED_LIMIT*2.0;
	}
	default void f() {
		System.out.println("f:");
	}
	default void f1() {
		System.out.println("f1:");
	}
	default void f2() {
		System.out.println("f2:");
	}
	//�ڽӿ������default�������Ա�֤Դ������ݣ��������±���ʵ����Ҳ����
	default void f3() {
		System.out.println("f3:");
	}
	//�Զ�����Ϊ���� public static final
	double SPEED_LIMIT=95;
}
