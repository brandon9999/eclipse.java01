/** AutoBoxing�� UnAutoBoxing�� �׽�Ʈ�ϴ� ���� **/

import java.util.Vector; 

public class AutoBoxingTest
{     
	public static void main(String[] args) 
	{        
		Vector<Integer> v = new Vector<Integer>();    
		v.addElement(100); //AutoBoxing �߻�        
		v.addElement(200); //AutoBoxing �߻�       
		int a0 = v.elementAt(0); //AutoUnBoxing �߻�    
		int a1 = v.elementAt(1); //AutoUnBoxing �߻�    
		System.out.println("index 0 : " + a0);  
		System.out.println("index 1 : " + a1);  
	}
}