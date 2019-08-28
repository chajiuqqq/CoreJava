package programme;

public interface Power extends Moveable {
	static double milesPerGallon() {
		return SPEED_LIMIT*2.0;
	}
	default void f() {
		System.out.println("f:");
	}
	default void f1() {
		System.out.println("f1:");
	}
	default void f2() {
		System.out.println("f2:");
	}
	//在接口里添加default方法可以保证源代码兼容，不必重新编译实现类也可以
	default void f3() {
		System.out.println("f3:");
	}
	//自动声明为常量 public static final
	double SPEED_LIMIT=95;
}
