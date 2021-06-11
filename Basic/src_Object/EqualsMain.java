/** 디폴트 equals()를 테스트하는 예제 **/

import java.lang.*; 

class Apple extends Object
{     
	//내용없음
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
