package thread;
/**
 * wait()��notify(),����Ҫ��ռ����������������
 * ����̱߳����ѣ� �ǻ�����Ӹղ�wait�ĵط���������ȥ����������ִ��run()
 * @author Alice
 * @version 2019��8��3��
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
							System.out.println("t1ռ����obj");
							System.out.println("t1����wait");
							obj.wait();
							//��t2���Ѻ�ֱ�Ӵ�ӡ��������䣬�����û�ٴ�ӡ
							System.out.println("t1�Ѿ�������");
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
				//��֤t1��ռ��obj
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}	
				synchronized (obj) {
					System.out.println("t2ռ����obj");
					System.out.println("���ϻ���obj���߳�");
					obj.notifyAll();
				}
			}
		};
		t1.start();
		t2.start();
	}
}
