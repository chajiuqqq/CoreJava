package ex;

import java.util.Random;

public class Initial_block_4_6_7 {
		//��������
		private static int id;
		private int count;
		
		//��ʼ��������static��ı���������������static
		static {
			//���RandomֻΪ��ʼ�������������������������ֻ������������
			Random aRandom=new Random();
			id=aRandom.nextInt(500);
		}
		
		//�Ա���ûɶҪ�󣬶�static��idҲ���Ը�ֵ
		{
			count=500;
			id=500;
		}
		//�����й�������Ĵ���飬Ȼ���������й�����������ݣ���ʹ���д����ҲҪ��������
		public Initial_block_4_6_7() {
			id=100;
			{
				id=300;
			}	
		}
		public static void main(String[] args) {
			Initial_block_4_6_7 aBlock_4_6_7=new Initial_block_4_6_7();
			System.out.println("id: "+Initial_block_4_6_7.id);
			System.out.println("count: "+aBlock_4_6_7.count);
		}
}
