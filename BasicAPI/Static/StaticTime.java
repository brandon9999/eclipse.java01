/** ����ƽ ������ ������ �׽�Ʈ�ϴ� ���� **/

public class StaticTime 
{    
	public static int special = 2000;    
	public static void main(String[] args)
	{        
		System.out.print("��ü ���� �� ����-StaticTime.special:");      
		//��ü ���� ������ Ŭ���� �̸����� ����ƽ�� ������ �� �ִ�.  
		System.out.println(StaticTime.special);          
		//��ü�� �̸��� �̿��ؼ� ����ƽ�� ������ �� �ִ�.    
		StaticTime s = new StaticTime();    
		s.special = 4000;                  
		System.out.println("��ü ���� �� ����-s.special:" + s.special);      
		System.out.print("��ü ���� �� ����-StaticTime.special:");  
		System.out.println(StaticTime.special);     
	}
}