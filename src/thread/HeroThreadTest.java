package thread;

public class HeroThreadTest {
	public static void main(String[] args) {
		Runnable r=()->{
			int i=1;
			try {
				while(true){
					System.out.println("����ȭ��"+i+"��");
					i++;
					Thread.sleep(1000);
					if(i==4){
						System.out.println("��ʼ5s�ĳ���");
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
