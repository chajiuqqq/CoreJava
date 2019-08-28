package thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
	public static void main(String[] args) {
		ThreadPoolExecutor myPool=new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
		while(true){
			myPool.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread()+"任务完成");
					try {
						Thread.sleep(2000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			});
		}
	}
}
