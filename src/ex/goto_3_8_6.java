package ex;

public class goto_3_8_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=10;
		label:
		while(i>0) {
			if(i<3)
				break label;
			System.out.println(i);
			i--;
		}
		System.out.println("out: "+i);
	}

}
