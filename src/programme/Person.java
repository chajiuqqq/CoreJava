package programme;

public abstract class Person implements Cloneable {
	private String name="";
	public Person(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public abstract void printDescribe();
	
}
