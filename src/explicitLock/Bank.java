package explicitLock;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	private final double[] account; 
	private Lock bankLock=new ReentrantLock();
	private Condition sufficientFunds;
	public Bank(int n,double initialBalance) {
		account=new double[n];
		Arrays.fill(account, initialBalance);
		sufficientFunds=bankLock.newCondition();
	}
	
	public  void transfer(int from,int to,double money) {
		bankLock.lock();
		try {
			//await是进入阻塞态，所以要处理InterruptedException
			while(account[from]<money) sufficientFunds.await();
			account[from]-=money;
			account[to]+=money;
			System.out.printf("%s  %.2f from %d to %d   Total Balance: %.5f\n",Thread.currentThread(),money,from,to,totalBalance());
			//完成转账后排除所有等待线程的阻塞
			sufficientFunds.signalAll();
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally {
			// TODO: handle finally clause
			bankLock.unlock();
		}
	}
	public double totalBalance() {
		bankLock.lock();
		try{
			double all=0;
			for(double x:account)
				all+=x;
			return all;
		}finally{
			bankLock.unlock();
		}
	}
	public int getSize() {
		return account.length;
	}
}
