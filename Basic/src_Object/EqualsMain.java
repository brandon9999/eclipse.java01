/** ����Ʈ equals()�� �׽�Ʈ�ϴ� ���� **/

import java.lang.*; 

class Apple extends Object
{     
	//�������
}

public class EqualsMain
{    
	public static void main(String[] args)
	{      
		Apple a1 = new Apple();    
		Apple a2 = new Apple();     
		System.out.println("a1 == a2 : " + (a1 == a2));    
		System.out.println("a1.equals(a2) : " + a1.equals(a2));    
	}  
}
