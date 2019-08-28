package thread;

public class HeroThreadTest {
	public static void main(String[] args) {
		Runnable r=()->{
			int i=1;
			try {
				while(true){
					System.out.println("波动拳第"+i+"次");
					i++;
					Thread.sleep(1000);
					if(i==4){
						System.out.println("开始5s的充能");
						Thread.sleep(5000);
						i=1;
					}
				}
				
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		};
		
		Thread t=new Thread(r);
		t.start();
	}
}
