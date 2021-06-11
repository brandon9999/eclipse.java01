/** toString()의 재정의를 테스트하는 예제 **/

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
		//toString() 재정의    
		return name + " " + id;    
		 
	}    
}	
	
public class ToStringMain2 
{    
	public static void main(String[] args)
	{      
		EBook e1 = new EBook(1000, "노인과 바다");     
		EBook e2 = new EBook(2000, "이방인");    
		System.out.println("e1: " +  e1); //객체 변수의 출력    
		System.out.println("e2: " +  e2); //객체 변수의 출력     
		System.out.println("e1.toString(): " +  e1.toString());  
		System.out.println("e2.toString(): " +  e2.toString());    
	} 
}

	
