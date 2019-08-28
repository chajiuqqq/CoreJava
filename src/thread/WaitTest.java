package thread;
/**
 * wait()和notify(),都是要在占用了锁对象后才能用
 * 如果线程被唤醒， 那会继续从刚才wait的地方继续做下去，不会重新执行run()
 * @author Alice
 * @version 2019年8月3日
 */
public class WaitTest {
	public static void main(String[] args) {
		Object obj=new Object();
		Thread t1=new Thread(){
			@Override
			public void run() {
				while(true){
					synchronized (obj) {
						try {
							Thread.sleep(1000);
							System.out.println("t1占用了obj");
							System.out.println("t1马上wait");
							obj.wait();
							//被t2唤醒后直接打印了下面这句，上面的没再打印
							System.out.println("t1已经被唤醒");
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}	
					}
				}
			}
		};
		
		Thread t2=new Thread(){
			@Override
			public void run() {
				//保证t1先占用obj
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}	
				synchronized (obj) {
					System.out.println("t2占用了obj");
					System.out.println("马上唤醒obj上线程");
					obj.notifyAll();
				}
			}
		};
		t1.start();
		t2.start();
	}
}
