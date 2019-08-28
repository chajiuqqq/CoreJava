package synch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	private final double[] account; 
	public Bank(int n,double initialBalance) {
		account=new double[n];
		Arrays.fill(account, initialBalance);
		
	}
	
	public  synchronized void transfer(int from,int to,double money) {
		try{
			while(account[from]<money) wait();
			account[from]-=money;
			account[to]+=money;
			System.out.printf("%s  %.2f from %d to %d   Total Balance: %.5f\n",Thread.currentThread(),money,from,to,totalBalance());
			notifyAll();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	public synchronized double totalBalance() {
		double all=0;
		for(double x:account)
			all+=x;
		return all;
	}
	public int getSize() {
		return account.length;
	}
}
