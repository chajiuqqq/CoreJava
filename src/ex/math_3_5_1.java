package ex;
import static java.lang.Math.*;
public class math_3_5_1 {
	public static void main(String[] args) {
		double x=sqrt(15);
		double y=pow(2,5);
	
		String xString=String.format("%.5f", x);
		String yString=String.format("%.5f",y);
		System.out.println(xString+ "\n"+yString);
	}
}
