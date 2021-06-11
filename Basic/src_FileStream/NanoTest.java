/** System.nanoTime()테스트 **/

public class NanoTest
{     
	public static void main(String[] args) throws InterruptedException
	{         
		long psecond = System.nanoTime();          
		Thread.sleep(1000);         
		psecond = System.nanoTime() - psecond;          
		System.out.println("1초는 " + psecond + "입니다.");     
	} 
} 