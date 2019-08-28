package cn.how2j;

public class Hero{
	private String name;
	private int id;
	private double hp;
	private double max_hp;
	public Hero() {
		// TODO Auto-generated constructor stub
	}
	public Hero(String name,int id) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.id=id;
	}
	public Hero(String name,double hp) {
		this.name=name;
		this.hp=hp;
		this.max_hp=hp;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getHp() {
		return hp;
	}
	public void setHp(double currentHp) {
		hp=currentHp;
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
