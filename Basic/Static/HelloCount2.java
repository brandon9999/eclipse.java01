/** 스태틱 멤버 변수를 테스트하는 예제 **/

public class HelloCount2 
{    
	//sCount의 값은 단 한번만 초기화    
	private static int sCount = 0;     
	//nCount의 값은 객체를 생성할 때마다 초기화   
	private int nCount = 0;    
	public void sayHello()
	{       
		sCount = sCount + 1;      
		nCount = nCount + 1;    
		System.out.println( "전체:" + sCount + "번째 인사를 합니다. Hello!");  
		System.out.println( this + "는 " + nCount + "번째 인사를 합니다. Hi!");   
	}   
	
	public static void main(String[] args) 
	{        
		HelloCount2 h1 = new HelloCount2();    
		HelloCount2 h2 = new HelloCount2();       
		//h1은 2번 인사      
		System.out.println(h1 + "의 인사");       
		h1.sayHello();       
		h1.sayHello();        
		System.out.println();//단순히 다음 라인으로 보내기 위해서 호출       
		//h2는 3번 인사      
		System.out.println(h2 + "의 인사");    
		h2.sayHello();       
		h2.sayHello();    
		h2.sayHello();   
      //전체는 5번인사....   
	}
}