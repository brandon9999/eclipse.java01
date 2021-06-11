/** 
 * 디폴트 toString()을 테스트하는 예제 
 * 결과값에서 @ 앞의 toy는 해당 객체의 타입을 의미하며, @ 다음의 16진수는 객체의 고유번호를 의미한다. 
 * 
 **/

class Toy extends Object
{
	//내용없음
}	

public class ToStringMain
{     
	public static void main(String[] args)
	{        
		Toy t = new Toy();   
		System.out.println(t);       
		System.out.println(t.toString());    
	} 
}  
