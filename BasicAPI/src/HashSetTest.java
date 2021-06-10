/** HashSet Å¬·¡½ºÀÇ »ç¿ë **/

import java.util.*; 

public class HashSetTest
{      
	public static void main(String args[])
	{         
		Set<String> set = new HashSet<String>();    
		set.add("±è»ñ°«");     
		set.add("È«±æµ¿");       
		set.add("ÃáÇâÀÌ");       
		set.add("ÀÌµµ·É");         
		set.add("Çâ´ÜÀÌ");         
		System.out.println("HashSet : " + set);      
		set.remove("ÀÌµµ·É");       
		System.out.println(set.contains("È«±æµ¿"));    
		Iterator<String> iter = set.iterator();        
		
		while(iter.hasNext())
		{            
			String temp = iter.next();    
			System.out.print(temp + ", ");     
		}         
		System.out.println();  
	}   
} 