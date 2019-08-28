package Table;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 设计了Hero的DAO
 * DAO=DataAccess Object	数据访问对象
 * 将对hero数据库的基本操作封装在HeroDAO类中
 * 如果别的类需要访问Hero数据库，直接通过这个类可以获得相关Hero信息
 * @author Alice
 * @version 2019年8月7日
 */
public class HeroDAO implements DAO{
	public HeroDAO() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnected() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
	}
	@Override
	public void add(Hero hero) {
		// TODO Auto-generated method stub

		String sql="insert into hero values(?,?,?,?)";
		try(Connection c=getConnected();
			PreparedStatement ps=c.prepareStatement(sql);){
			ps.setInt(1, hero.getId());
			ps.setString(2, hero.getName());
			ps.setDouble(3, hero.getHp());
			ps.setDouble(4, hero.getDamage());
			
			ps.execute();
			
			System.out.println("添加了id为:"+hero.getId()+"的英雄");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void update(Hero hero) {
		// TODO Auto-generated method stub
		String sql="update hero set name=?,hp=?,damage=? where id=?";
		try(Connection c=getConnected();
			PreparedStatement ps=c.prepareStatement(sql);){
			ps.setString(1, hero.getName());
			ps.setDouble(2, hero.getHp());
			ps.setDouble(3, hero.getDamage());
			ps.setInt(4, hero.getId());
			ps.execute();
			System.out.println("更新了id为:"+hero.getId()+"叫"+hero.getName()+"的英雄");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from hero where id=?";
		try(Connection c=getConnected();
			PreparedStatement ps=c.prepareStatement(sql);){
		
			ps.setInt(1, id);
			ps.execute();
			System.out.println("删除了id为:"+id+"的英雄");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}

	@Override
	public Hero get(int id) {
		// TODO Auto-generated method stub

		String sql="select * from hero where id = ?";
		try(Connection c=getConnected();
			PreparedStatement ps=c.prepareStatement(sql);){
			
			ps.setInt(1, id);
			ResultSet result=ps.executeQuery();
			
			Hero hero=null;
			if(result.next()){
				
				String name=result.getString(2);
				double hp=result.getDouble(3);
				double damage=result.getDouble(4);
				hero=new Hero(id,name,hp,damage);
				System.out.println("取出了id："+hero.getId()+"叫"+hero.getName()+"的英雄");
			}
			return hero;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Hero> list() {
		//按照id倒序返回list
		String sql="select * from hero order by id desc";
		try(Connection c=getConnected();
			PreparedStatement ps=c.prepareStatement(sql);){
			List<Hero> list=new ArrayList<>();
			
			ResultSet result=ps.executeQuery();
			while(result.next()){
				int id=result.getInt(1);
				String name=result.getString(2);
				double hp=result.getDouble(3);
				double damage=result.getDouble(4);
				list.add(new Hero(id,name, hp, damage));
			}
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
			
		}
	}

	@Override
	public List<Hero> list(int start, int count) {
		// TODO Auto-generated method stub
		String sql="select * from hero order by id desc limit ?,?";
		try(Connection c=getConnected();
			PreparedStatement ps=c.prepareStatement(sql);){
			List<Hero> list=new ArrayList<>();
			
			ps.setInt(1, start);
			ps.setInt(2, count);
			
			ResultSet result=ps.executeQuery();
			while(result.next()){
				int id=result.getInt(1);
				String name=result.getString(2);
				double hp=result.getDouble(3);
				double damage=result.getDouble(4);
				list.add(new Hero(id,name, hp, damage));
			}
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
			
		}
	}
	public static void main(String[] args) {
		HeroDAO dao=new HeroDAO();
		
		dao.list();
		dao.add(new Hero(12038, "tim", 500.3, 53.3));
		dao.list();
		dao.update(new Hero(12038, "joo", 55000, 1222));
		dao.get(12038);
		dao.delete(12038);
		List<Hero> list=dao.list();
		System.out.println(list.size());
		
	}
}
