package programme;

import java.util.Arrays;
import java.util.Comparator;

class LengthComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.length()-o2.length();
	}
	
}


public class ComparatorTest {
	public static void main(String[] args) {
		String[] aStrings= {"abcde","abcd","abcdef"};
		Arrays.sort(aStrings,new LengthComparator());
		
		System.out.println(Arrays.toString(aStrings));
		
	}
}
