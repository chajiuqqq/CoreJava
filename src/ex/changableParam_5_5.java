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
		//可变参数可以自动装箱，使用数组参数要传数组对象进去
		cal(10.5,1.6,-5.2,9.2,12.3);
		cal2(new double[] {10.5,1.6,-5.2,9.2,12.3});
	}
}
