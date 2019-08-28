package thread;
/**
 * 练习死锁
 * 3个同步对象a, b, c
	3个线程 t1,t2,t3
	故意设计场景，使这3个线程彼此死锁
 * @author Alice
 * @version 2019年8月2日
 */
public class DeathLockTest {
	public static void main(String[] args) {
		final Object a=new Object();
		final Object b=new Object();
		final Object c=new Object();
		Thread t1=new Thread(){
			@Override
			public void run() {
				synchronized(a){
					System.out.println(Thread.currentThread().getName()+" 已经占据了 a");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+" 试图占据b");
					synchronized (b) {
						System.out.println(Thread.currentThread().getName()+" 已经占据了 b");
					}
				}
					
			}
			
		};
		t1.setName("t1");
		Thread t2=new Thread(){
			@Override
			public void run() {
				synchronized(b){
					System.out.println(Thread.currentThread().getName()+" 已经占据了 b");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+" 试图占据c");
					synchronized (c) {
						System.out.println(Thread.currentThread().getName()+" 已经占据了 c");
					}
				}
				
			}
			
		};
		t2.setName("t2");
		Thread t3=new Thread(){
			@Override
			public void run() {
				synchronized(c){
					System.out.println(Thread.currentThread().getName()+" 已经占据了 c");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+" 试图占据a");
					synchronized (a) {
						System.out.println(Thread.currentThread().getName()+" 已经占据了 a");
					}
				}
				
			}
			
		};
		t3.setName("t3");
		t1.start();
		t2.start();
		t3.start();
	}
}
