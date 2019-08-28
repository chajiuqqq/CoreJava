package thread;

public class YieldTest {
	public static void main(String[] args) {
		Thread t1=new Thread(){
			int i=100;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					Thread.yield();
					System.out.println(Thread.currentThread()+"  "+i);
					i--;
				}
			}
		};
		Thread t2=new Thread(new P(),"t2");
		t1.setName("t1");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		
	}
	

	

}
