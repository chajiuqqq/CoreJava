package ex;

public class PriorityThreadTest {
	public static void main(String[] args) {
		Runnable r=()->{
			while(true){
				System.out.println(Thread.currentThread().getName());	
				Thread.yield();
			}
		};
		Thread a=new Thread(r,"a");
		Thread b=new Thread(r,"b");
		Thread c=new Thread(r,"c");
		a.setPriority(1);
		b.setPriority(2);
		c.setPriority(9);
		a.start();
		b.start();
		c.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
