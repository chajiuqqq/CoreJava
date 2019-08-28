package thread;

import java.util.LinkedList;
/**
 * 自己建立的线程池，拥有固定数量的线程，负责处理tasks里的Runnable任务。
 * 如果tasks里为空，则所有线程进入wait()
 * 如果进行了addTask，或者执行完一个任务，则唤醒所有线程
 * @author Alice
 *
 */
public class ThreadPool {
	LinkedList<Runnable> tasks=new LinkedList<>();
	private int poolSize;
	
	public ThreadPool(int size) {
		// TODO Auto-generated constructor stub
		poolSize=size;
		for(int i=0;i<poolSize;i++){
			new ConsumerThread("消费者线程"+i).start();
		}
	}
	public void addTask(Runnable task) {
		synchronized (tasks) {
			tasks.add(task);
			tasks.notifyAll();
		}
		
	}
	class ConsumerThread extends Thread{
		Runnable task;
		
		public ConsumerThread(String name) {
			// TODO Auto-generated constructor stub
			super(name);
			
		}
		@Override
		public void run() {
			System.out.println("启动:"+Thread.currentThread().getName());
			while(true){
				synchronized (tasks) {
					try {
						while(tasks.isEmpty()){
							tasks.wait();
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					task=tasks.removeFirst();
					tasks.notifyAll();
				}
				task.run();
				System.out.println(Thread.currentThread().getName()+"开始执行任务");
			}
		}
		
	}
}
