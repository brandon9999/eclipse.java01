/** System.nanoTime()�׽�Ʈ **/

public class NanoTest
{     
	public static void main(String[] args) throws InterruptedException
	{         
		long psecond = System.nanoTime();          
		Thread.sleep(1000);         
		psecond = System.nanoTime() - psecond;          
		System.out.println("1�ʴ� " + psecond + "�Դϴ�.");     
	} 
} 