/** ��ü �迭�� �׽�Ʈ�ϴ� �� **/

class Dog 
{  
	private String name;  
	private String kind;  
	public Dog(String name, String kind) 
	{       
		this.name = name;    
		this.kind = kind;    
	}   
	public String toString() 
	{         
		return kind + ":" + name; 
	}
}   

public class ArrayObjectTest 
{
	public static void main(String[] args) 
	{       
		//1. ��ü�迭�� ����  
		Dog[] dog = new Dog[5];  
		for(int i=0; i<dog.length; i++)     
			System.out.println("Dog[" + i + "] : " + dog[i]);   
		//2. ��ü�迭�� ���������� �޸��Ҵ�   
		dog[0] = new Dog("������","�ҵ�");     
		dog[1] = new Dog("����","�˰�");   
		dog[2] = new Dog("������","������");     
		dog[3] = new Dog("�߸�","Ǫ��");       
		dog[4] = new Dog("������","����");        
		for(int i=0; i<dog.length; i++)      
			System.out.println("Dog[" + i + "] : " + dog[i]);  
	}
}