package thread;

import java.util.LinkedList;
/**
 * �Լ��������̳߳أ�ӵ�й̶��������̣߳�������tasks���Runnable����
 * ���tasks��Ϊ�գ��������߳̽���wait()
 * ���������addTask������ִ����һ���������������߳�
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
			new ConsumerThread("�������߳�"+i).start();
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
			System.out.println("����:"+Thread.currentThread().getName());
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
				System.out.println(Thread.currentThread().getName()+"��ʼִ������");
			}
		}
		
	}
}
