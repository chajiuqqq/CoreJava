package ex;

public class changableParam_5_5 {
	public static void cal(double...ds) {
		double max=ds[0];
		for(double x:ds) {
			if(x>max)
				max=x;
		}
		System.out.println("max: "+max);
	}
	public static void cal2(double[] ds) {
		double max=ds[0];
		for(double x:ds) {
			if(x>max)
				max=x;
		}
		System.out.println("max: "+max);
	}
	public static void main(String[] args) {
		//�ɱ���������Զ�װ�䣬ʹ���������Ҫ����������ȥ
		cal(10.5,1.6,-5.2,9.2,12.3);
		cal2(new double[] {10.5,1.6,-5.2,9.2,12.3});
	}
}
