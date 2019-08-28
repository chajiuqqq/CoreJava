package ex;

public class InterruptedExceptionTest implements Runnable{
	 public void run(){
         try {
             while (true) {
                 Boolean a = Thread.currentThread().isInterrupted();
                 System.out.println("in run() - about to sleep for 20 seconds-------" + a);
                 Thread.sleep(20000);
                 System.out.println("in run() - woke up");
             }
         } catch (InterruptedException e) {
             Thread.currentThread().interrupt();//�����������һ�䣬��ôcd���ᶼ��false����Ϊ�ڲ�׽��InterruptedException�쳣��ʱ��ͻ��Զ����жϱ�־��Ϊ��false
             Boolean c=Thread.interrupted();
             Boolean d=Thread.interrupted();
             System.out.println("c="+c);
             System.out.println("d="+d);
         }
	 }
	 public static void main(String[] args) {
		 InterruptedExceptionTest si = new InterruptedExceptionTest();
	     Thread t = new Thread(si);
	     t.start();
	     //���߳�����2�룬�Ӷ�ȷ���ղ��������߳��л���ִ��һ��ʱ��
	     try {
	         Thread.sleep(2000);
	     }catch(InterruptedException e){
	         e.printStackTrace();
	     }
	     System.out.println("in main() - interrupting other thread");
	     //�ж��߳�t,ֻ�������߳�t�������жϱ�־λΪture����û�н����߳�t�д���
	     //�����ȴ�ӡ����һ��"in main() - leaving"���ٽ���t
	     t.interrupt();
	     System.out.println("in main() - leaving");
	 }
}
