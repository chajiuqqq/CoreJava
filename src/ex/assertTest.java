package ex;

class Ts{
	public static void sqrt(int x) {
		assert x>=0;
		System.out.println(x);
	}
}


public class assertTest {

	public static void main(String[] args) {
		Ts.sqrt(-1);
	}
}
