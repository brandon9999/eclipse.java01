/** ����ƽ ��� ������ �׽�Ʈ�ϴ� ���� **/

public class HelloCount 
{    
	//sCount�� ���� �� �ѹ��� �ʱ�ȭ    
	private static int sCount = 0;     
	//nCount�� ���� ��ü�� ������ ������ �ʱ�ȭ   
	private int nCount = 0;    
	public void sayHello()
	{       
		sCount = sCount + 1;      
		nCount = nCount + 1;    
		System.out.println( "��ü:" + sCount + "��° �λ縦 �մϴ�. Hello!");  
		System.out.println( this + "�� " + nCount + "��° �λ縦 �մϴ�. Hi!");   
	}   
	
	public static void main(String[] args) 
	{        
		HelloCount h1 = new HelloCount();    
		HelloCount h2 = new HelloCount();       
		//h1�� 2�� �λ�      
		System.out.println(h1 + "�� �λ�");       
		h1.sayHello();       
		h1.sayHello();        
		System.out.println();//�ܼ��� ���� �������� ������ ���ؼ� ȣ��       
		//h2�� 3�� �λ�      
		System.out.println(h2 + "�� �λ�");    
		h2.sayHello();       
		h2.sayHello();    
		h2.sayHello();   
      //��ü�� 5���λ�   
	}
}