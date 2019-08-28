package thread;

import stack.MyStack;

public class ConsumerProblem {
	/**
	 * �������A-Z����ĸ
	 * @return
	 */
	public static char randomChar() {
		int num=(int)(('Z'-'A')*Math.random());
		char ch=(char)('A'+num);
		return ch;
	}
	
	
	public static void main(String[] args) {
		MyStack<Character> myStack=new MyStack<>();
		
		Thread producer=new Thread(){
			@Override
			public void run() {
				while(true){
					synchronized (myStack) {
						try {
							while(myStack.size()==200)
								myStack.wait();
							char val=randomChar();
							myStack.push(val);
							System.out.println("producer ѹ��ջ:"+val);
							
							Thread.sleep(200);
							myStack.notifyAll();
							
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}	
					}
					
				
				}
			}
		};
		
		Thread consumer=new Thread(){
			@Override
			public void run() {
				while(true){
					synchronized (myStack) {
						try {
							while(myStack.size()==0)
								myStack.wait();	
							System.out.println("consumer ����:"+myStack.pull());
						
							Thread.sleep(200);
							myStack.notifyAll();
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
	
					}
									}
			}
		};
		producer.start();
		consumer.start();
		
	}
}	
