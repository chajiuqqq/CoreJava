package programme;

public class PermSolution{
	public static  void swap(char[] list,int start,int end) {
		char temp=list[start];
		list[start]=list[end];
		list[end]=temp;
	}
	public static  void printList(char[] list) {
		System.out.println("============");
		for(char x:list){
			System.out.print(x);
		}
		System.out.println();
		
	}
	public static  void perm(char[] list,int start,int end) {
		if(start==end){
			printList(list);
		}else{
			for(int i=start;i<=end;i++){
				swap(list, start, i);
				perm(list, start+1, end);
				swap(list, i, start);
			}
		}
	}
	public static void main(String[] args) {
		char[] list="abcd".toCharArray();
		perm(list, 0, list.length-1);
		
	}
}
