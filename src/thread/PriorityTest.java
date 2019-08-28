package thread;
/**
 * t1���ȼ�����t2��������ռcpu�Ļ���ࡣ
 * ����ʱ��Ҳ�ᱻt2��ȥ��
 * @author Alice
 *
 */
public class PriorityTest {
		public static void main(String[] args) {
			P r=new P();
			Thread t1=new Thread(r,"t1");
			Thread t2=new Thread(r,"t2");
			
			t1.setPriority(Thread.MAX_PRIORITY);
			t2.setPriority(Thread.MIN_PRIORITY);
			t1.start();
			t2.start();
			
		}
}
	class P implements Runnable{
		int i=100;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				System.out.println(Thread.currentThread()+"  "+i);
				i--;
			}
		}
		
	}