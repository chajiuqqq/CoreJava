package programme;

public class PersonTest {
	public static void main(String[] args) {
		//����Ҳ�Ƕ���Ҳ��Object�����࣬���Կ���ֱ��obj=persons;
		Person[] persons=new Person[2];
		Object obj;
		obj=persons;
		//error
		//Person pp;
		//pp=persons;
		persons[0]=new Employee("Sam", 10000, 1998, 10, 25);
		persons[1]=new Student("Jack", "CS");
		
		for(Person x:persons) {
			x.printDescribe();
		}
	}
}
