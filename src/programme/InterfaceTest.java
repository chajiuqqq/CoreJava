package programme;


class Car implements Power{
	private int speed=0;
	private String name="";
	public static Car myCar=new Car();
	public Car(){
		
	}
	public Car(String name,int speed) {
		this.speed=speed;
		this.name=name;
	}
	public int getSpeed() {
		return speed;
	}
	@Override
	public void move(double x, double y) {
		// TODO Auto-generated method stub
		System.out.println("the car move to: ("+x+","+y+")");
		System.out.println("the milesPerGallon is "+Power.milesPerGallon());
	}
	
	@Override
	public void f() {
		// TODO Auto-generated method stub
		System.out.println("override f");
	}
	//访问接口中的default方法
	public void visitf1() {
		Power.super.f1();
		Power.milesPerGallon();
	}
	
	public static int compareInstance(Car o1,Car o2) {
		return o1.speed-o2.speed;
	}
	public int compareStatic(Car o1,Car o2) {
		return o1.speed-o2.speed;
	}
	public static void rank(Car o1,Car o2, CarComparator myCarComparator ) {
		int result=myCarComparator.compare(o1, o2);
		System.out.print("out: ");
		System.out.println(result>0?o1:o2);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+"&"+speed;
	}
	
}

public class InterfaceTest {
	public static void main(String[] args) {
		Car car1=new Car("1",100);
		Car car2=new Car("2",20);
		
		Car.rank(car1,car2,(first,second)->first.getSpeed()-second.getSpeed());
		Car.rank(car1,car2,Car::compareInstance);
		Car.rank(car1, car2, Car.myCar::compareStatic);
	}
}
