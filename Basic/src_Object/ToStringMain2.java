/** toString()�� �����Ǹ� �׽�Ʈ�ϴ� ���� **/

class EBook 
{      
	private int id;   
	private String name;  
	public EBook(int id, String name) 
	{        
		this.id = id;    
		this.name = name;    
	}     
	public String toString()
	{ 
		//toString() ������    
		return name + " " + id;    
		 
	}    
}	
	
public class ToStringMain2 
{    
	public static void main(String[] args)
	{      
		EBook e1 = new EBook(1000, "���ΰ� �ٴ�");     
		EBook e2 = new EBook(2000, "�̹���");    
		System.out.println("e1: " +  e1); //��ü ������ ���    
		System.out.println("e2: " +  e2); //��ü ������ ���     
		System.out.println("e1.toString(): " +  e1.toString());  
		System.out.println("e2.toString(): " +  e2.toString());    
	} 
}

	
