/** 현재의 메서드가 속해 있는 스레드의 정보 출력 **/

public class CurrentThreadMain
{     
	public static void main(String[] args)
	{       
		Thread t = Thread.currentThread();   
		System.out.println("main()의 스레드: " + t );  
	}  
}