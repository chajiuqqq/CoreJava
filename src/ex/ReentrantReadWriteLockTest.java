package ex;

public class ReentrantReadWriteLockTest {
	public static void main(String[] args) {
		Hero timo=new Hero("timo", 500.0);
		timo.setHp(10.0);
		for(int i=0;i<5;i++){
			Thread read=new Thread(){
				@Override
				public void run() {
					while(true){
						System.out.println(Thread.currentThread().getName()+"��ǰhpΪ��"+timo.getHp());
						try {
							Thread.sleep(500);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}
			};
			read.setName("read�߳�"+(i+1));
			read.start();
		}
		
		for(int i=0;i<2;i++){
			Thread write=new Thread(){
				@Override
				public void run() {
					while(true){
						System.out.println(Thread.currentThread().getName()+"�����޸�");
						timo.setHp(timo.getHp()+1);
						System.out.println(Thread.currentThread().getName()+"�޸����");
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						
					}
				}
			};
			write.setName("write�߳�"+(i+1));
			write.start();
		}
	}
}
