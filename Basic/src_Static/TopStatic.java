/** ����ƽ ��� �޼��带 �׽�Ʈ�ϴ� ���� **/

public class TopStatic 
{     
	//����ƽ ��� �޼���  
	public static int sum(int x, int y)
	{         
		return x + y;   
	}        
	//�Ϲ� ��� �޼���  
	public int minus(int x, int y)
	{          
		return x - y;   
	}   
	public static void main(String[] args)
	{        
		//1. Ŭ���� �̸����� ����ƽ ��� �޼��忡 ����    
		int s1 = TopStatic.sum(100, 200);   
		System.out.println("TopStatic.sum(100, 200):" + s1);     
		//2. ��ü�� �̸����� ����ƽ ��� �޼��忡 ����      
		TopStatic t = new TopStatic();      
		int s2 = t.sum(100, 200);         
		System.out.println("t.sum(100,200):" + s2);        
		//3. �Ϲ� ��� �޼����� ����       
		int s3 = t.minus(100,200);      
		System.out.println("t.minus(100,200):" + s3);   
	}
}