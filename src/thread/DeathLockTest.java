package thread;
/**
 * ��ϰ����
 * 3��ͬ������a, b, c
	3���߳� t1,t2,t3
	������Ƴ�����ʹ��3���̱߳˴�����
 * @author Alice
 * @version 2019��8��2��
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
					System.out.println(Thread.currentThread().getName()+" �Ѿ�ռ���� a");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+" ��ͼռ��b");
					synchronized (b) {
						System.out.println(Thread.currentThread().getName()+" �Ѿ�ռ���� b");
					}
				}
					
			}
			
		};
		t1.setName("t1");
		Thread t2=new Thread(){
			@Override
			public void run() {
				synchronized(b){
					System.out.println(Thread.currentThread().getName()+" �Ѿ�ռ���� b");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+" ��ͼռ��c");
					synchronized (c) {
						System.out.println(Thread.currentThread().getName()+" �Ѿ�ռ���� c");
					}
				}
				
			}
			
		};
		t2.setName("t2");
		Thread t3=new Thread(){
			@Override
			public void run() {
				synchronized(c){
					System.out.println(Thread.currentThread().getName()+" �Ѿ�ռ���� c");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+" ��ͼռ��a");
					synchronized (a) {
						System.out.println(Thread.currentThread().getName()+" �Ѿ�ռ���� a");
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
