package thread;

/**
 * ����join������
 * ȷʵ�����t.join()����ô����t�̣߳�ֱ���߳�����(��ɻ����׳��쳣)�����������µ��߳�(���̻߳��������߳�)
 * @author Alice
 *
 */
public class JoinTest {
	
	public static void main(String[] args) {
		
		Thread t1=new Thread(new R(),"t1");
		Thread t2=new Thread(new R(),"t2");
		Thread t3=new Thread(new R(),"t3");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println(Thread.currentThread());
		t2.start();
		t3.start();
	}
}

class R implements Runnable{
	int i=3;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println(Thread.currentThread()+"  "+i);
			i--;
			try {
				Thread.sleep(1000);
				if(i<0) return;
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}
	
}
