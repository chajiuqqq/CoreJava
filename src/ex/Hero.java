package ex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriter类测试
 * @author Alice
 *
 */
public class Hero{
	private String name;
	private int id;
	private double hp;
	private double max_hp;
	private ReentrantReadWriteLock rwl;
	private Lock readLock;
	private Lock writeLock;
	public Hero() {
		// TODO Auto-generated constructor stub
		rwl=new ReentrantReadWriteLock();
		readLock=rwl.readLock();
		writeLock=rwl.writeLock();
	}
	public Hero(String name,int id) {
		// TODO Auto-generated constructor stub
		this();
		this.name=name;
		this.id=id;
	}
	public Hero(String name,double hp) {
		this();
		this.name=name;
		this.hp=hp;
		this.max_hp=hp;
	}
	public int getId() {
		readLock.lock();
		try {
			return id;
		} finally {
			// TODO: handle finally clause
			readLock.unlock();
		}
		
	}
	public String getName() {
		readLock.lock();
		try {
			return name;
		} finally {
			// TODO: handle finally clause
			readLock.unlock();
		}
		
	}
	public double getHp() {
		readLock.lock();
		try {
			return hp;
		} finally {
			// TODO: handle finally clause
			readLock.unlock();
		}
	}
	public void setHp(double currentHp) {
		writeLock.lock();
		try {
			hp=currentHp;
		} finally {
			// TODO: handle finally clause
			writeLock.unlock();
		}
	}
	public synchronized void hurt() {
		try {
			while(hp==1)
				wait();
			
			hp--;
			notifyAll();
			System.out.println(Thread.currentThread()+"  "+getName()+"受到1点伤害，目前血量为"+getHp());
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public synchronized void heal() {
		try {
			while(hp==max_hp)
				wait();
		
			hp++;
			System.out.println(Thread.currentThread()+"  "+getName()+"受到1点治疗，目前血量为"+getHp());
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+name+" "+id+"]";
	}
	
}
