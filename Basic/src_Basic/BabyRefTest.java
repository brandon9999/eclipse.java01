/** 객체의 참조를 테스트하기 위한 예제 **/

class Baby
{      
	private String name;  
	public void setName(String name)
	{        
		this.name = name;  
	}   
	public void cry()
	{     
		System.out.println(name + " 가(이) 응애응애");  
	} 
} 

public class BabyRefTest 
{  
	public static void main(String[] args) 
	{      
		Baby b = new Baby();   
		b.setName("둘리");       
		b.cry();      
		Baby s = b;       
		s.setName("아기공룡");  
		s.cry();     
		b.cry(); 
	}
}  