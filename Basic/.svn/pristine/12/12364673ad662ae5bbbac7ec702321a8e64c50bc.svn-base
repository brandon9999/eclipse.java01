/** static 멤버 필드를 테스트하는 예제 **/

public class StaticConcept 
{    
	//static 멤버 변수 s는 하나의 메모리만 생성하기 때문에    
	//어느 곳에서 값을 바꾸든 하나의 메모리를 상대하는 것이 된다.    
	public static int s; //스태틱 멤버 변수 선언      
	
	public int a; //일반 멤버 변수     
	public int b; //일반 멤버 변수 
	public int c; //일반 멤버 변수   
	public int d; //일반 멤버 변수    
	public int e; //일반 멤버 변수      
	public static void main(String[] args) 
	{        
		StaticConcept st1 = new StaticConcept(); //객체 생성
		StaticConcept st2 = new StaticConcept(); //객체 생성      
		StaticConcept st3 = new StaticConcept(); //객체 생성          
		//멤버 변수에 데이터 할당       
		st1.s = 1; st1.a = 1; st1.b = 2;      
		st1.c = 3; st1.d = 4; st1.e = 5;    
		st2.s = 10; st2.a = 10; st2.b = 20;      
		st2.c = 30; st2.d = 40; st2.e = 50; 
		st3.s = 100; st3.a = 100; st3.b = 200;  
		st3.c = 300; st3.d = 400; st3.e = 500;     
		//멤버 변수의 데이터 출력      
		System.out.print("st1:" + st1.s +","+ st1.a +","+ st1.b);  
		System.out.println("," + st1.c +","+ st1.d +","+ st1.e);   
		System.out.print("st2:" + st2.s +","+ st2.a +","+ st2.b);   
		System.out.println(","+ st2.c +","+ st2.d +","+ st2.e);   
		System.out.print( "st3:" + st3.s +","+ st3.a +","+ st3.b); 
		System.out.println(","+ st3.c +","+ st3.d +","+ st3.e); 
	}
}