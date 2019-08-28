package ex;

import java.util.ArrayList;
import java.util.Date;

public class ViewTest {
	public static void main(String[] args) {
		ArrayList arrayList=new ArrayList<String>();
		arrayList.add("hello");
		arrayList.add(new Date());
		String a=(String)arrayList.get(0);
		/**
		 * error:
		 * java.util.Date cannot be cast to java.lang.String
		 */
		String b=(String)arrayList.get(1);
		
		
	}
}
