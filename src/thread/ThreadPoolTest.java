package thread;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ThreadPool myPool=new ThreadPool(10);
		while(true){
			Runnable task=()->{
				System.out.println("»ŒŒÒ÷¥––");
			};
			
			myPool.addTask(task);
			try {
				Thread.sleep(100);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
