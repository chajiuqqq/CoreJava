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
						System.out.println(Thread.currentThread().getName()+"当前hp为："+timo.getHp());
						try {
							Thread.sleep(500);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}
			};
			read.setName("read线程"+(i+1));
			read.start();
		}
		
		for(int i=0;i<2;i++){
			Thread write=new Thread(){
				@Override
				public void run() {
					while(true){
						System.out.println(Thread.currentThread().getName()+"正在修改");
						timo.setHp(timo.getHp()+1);
						System.out.println(Thread.currentThread().getName()+"修改完成");
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						
					}
				}
			};
			write.setName("write线程"+(i+1));
			write.start();
		}
	}
}
