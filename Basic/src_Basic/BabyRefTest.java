/** ��ü�� ������ �׽�Ʈ�ϱ� ���� ���� **/

class Baby
{      
	private String name;  
	public void setName(String name)
	{        
		this.name = name;  
	}   
	public void cry()
	{     
		System.out.println(name + " ��(��) ��������");  
	} 
} 

public class BabyRefTest 
{  
	public static void main(String[] args) 
	{      
		Baby b = new Baby();   
		b.setName("�Ѹ�");       
		b.cry();      
		Baby s = b;       
		s.setName("�Ʊ����");  
		s.cry();     
		b.cry(); 
	}
}  