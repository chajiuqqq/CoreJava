package ex;

import programme.Manager;
import programme.Pair;
/**
 * 8.7 �������͵ļ̳й���
 * @author Alice
 * @version 2019��7��23��
 */
public class ParamteriezdType_8_7{
	public static void main(String[] args) {
		
		Pair<Manager> a=new Pair<>(new Manager("ceo"),new Manager("cfo"));
		//���в��������Ͷ�����תΪһ��ԭʼ����
		Pair b=a;
		//���ض���ʱ��Ҫ�ֶ����ǿ��ת������objectתΪ��Ĳ�������
		Manager c=(Manager)b.getFirst();
		//������߶��ǲ��������ͣ����ض���ʱ���������Զ����ǿ��ת��
		Manager d=a.getFirst();
		
	}
}