/** 스태틱 변수의 접근을 테스트하는 예제 **/

public class StaticTime 
{    
	public static int special = 2000;    
	public static void main(String[] args)
	{        
		System.out.print("객체 생성 전 접근-StaticTime.special:");      
		//객체 생성 이전에 클래스 이름으로 스태틱에 접근할 수 있다.  
		System.out.println(StaticTime.special);          
		//객체의 이름을 이용해서 스태틱에 접근할 수 있다.    
		StaticTime s = new StaticTime();    
		s.special = 4000;                  
		System.out.println("객체 생성 후 접근-s.special:" + s.special);      
		System.out.print("객체 생성 후 접근-StaticTime.special:");  
		System.out.println(StaticTime.special);     
	}
}