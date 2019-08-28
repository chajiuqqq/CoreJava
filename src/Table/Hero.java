package Table;

public class Hero{
	private String name;
	private int id;
	private double hp;
	private double max_hp;
	private double damage;
	public Hero() {
		// TODO Auto-generated constructor stub
	}
	public Hero(String name,int id) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.id=id;
	}
	public Hero(int id,String name,double hp,double damage) {
		this.id=id;
		this.name=name;
		this.hp=hp;
		this.max_hp=hp;
		this.damage=damage;
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
	public double getDamage() {
		return damage;
	}
	public void setHp(double currentHp) {
		hp=currentHp;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+name+" "+id+"]";
	}
	
}
