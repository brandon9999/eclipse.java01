/** AutoBoxing과 UnAutoBoxing을 테스트하는 예제 **/

import java.util.Vector; 

public class AutoBoxingTest
{     
	public static void main(String[] args) 
	{        
		Vector<Integer> v = new Vector<Integer>();    
		v.addElement(100); //AutoBoxing 발생        
		v.addElement(200); //AutoBoxing 발생       
		int a0 = v.elementAt(0); //AutoUnBoxing 발생    
		int a1 = v.elementAt(1); //AutoUnBoxing 발생    
		System.out.println("index 0 : " + a0);  
		System.out.println("index 1 : " + a1);  
	}
}