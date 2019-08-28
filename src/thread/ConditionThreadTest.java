package thread;

import cn.how2j.Hero;

public class ConditionThreadTest {
	public static void main(String[] args) {
		Hero timo=new Hero("Timo", 1000.0);
		timo.setHp(1);
		Thread tHurt1=new Thread(){
			@Override
			public void run() {
				while(true){
					timo.hurt();
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		};
		Thread tHurt2=new Thread(){
			@Override
			public void run() {
				while(true){
					timo.hurt();
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		};
		Thread tHurt3=new Thread(){
			@Override
			public void run() {
				while(true){
					timo.hurt();
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		};
		Thread tHurt4=new Thread(){
			@Override
			public void run() {
				while(true){
					timo.hurt();
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		};
		Thread tHurt5=new Thread(){
			@Override
			public void run() {
				while(true){
					timo.hurt();
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		};
		Thread tHeal1=new Thread(){
			@Override
			public void run() {
				while(true){
					timo.heal();
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		};
		Thread tHeal2=new Thread(){
			@Override
			public void run() {
				while(true){
					timo.heal();
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		};
		
		tHurt1.start();
		tHurt2.start();
		tHurt3.start();
		tHurt4.start();
		tHurt5.start();
		tHeal1.start();
		tHeal2.start();
	}
}
