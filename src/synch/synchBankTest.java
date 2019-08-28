package synch;

public class synchBankTest {
	public static final int NACCOUNTS=10;
	public static final double INITIAL_BALANCE=1000;
	public static final double MAX_AMOUNT=2*INITIAL_BALANCE;
	public static final int DELAY=10;

	public static void main(String[] args) {
		Bank bank=new Bank(NACCOUNTS,INITIAL_BALANCE);
		for(int i=0;i<NACCOUNTS;i++){
			int fromAccount=i;
			//Runnable����һ�����������߳�ִ�е��������Կ��Ե�����lambdaд�����õ���дһ������
			Runnable r=()->{
				try {
					while(true){
						int toAccount=(int)(Math.random()*bank.getSize());
						double amount=Math.random()*MAX_AMOUNT;
						bank.transfer(fromAccount, toAccount, amount);
						Thread.sleep((int)(DELAY*Math.random()));
					}
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			};
			Thread t=new Thread(r);
			t.start();
		}
	}
}
