/** Advanced for문(for each문)의 사용 **/

import java.util.*; 

public class ForEachJava5
{   
	public static void main(String[] args)
	{        
		ArrayList<String> ar = new ArrayList<String>();  
		ar.add("안녕1");      
		ar.add("안녕2");    
		ar.add("안녕3");    
		//1. 일반적인 For문      
		for (Iterator<String> i = ar.iterator(); i.hasNext(); ) 
		{              
			String tmp = i.next();              
			System.out.println(tmp);         
		}        
		//2. For Each문 J2SE 5.0의 코드         
		for (String tmp : ar)
		{             
			System.out.println(tmp);     
		}    
	}
}