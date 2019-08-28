package ex;

public class typechange_3_5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=123456789;
		float x=n;//精度丢失，因为float有效数字只有6~7位，多了就不准了。
		double y=n;//有效数字15位
		System.out.println("n: "+n);
		System.out.println("x: "+x);
		System.out.println("y: "+y);
	}

}
