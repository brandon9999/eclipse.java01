/** HashSetÀ» ÀÌ¿ëÇØ¼­ TreeSet »ı¼º **/

import java.util.*; 

public class TreeSetTest
{   
	public static void main(String args[]) 
	{         
		Set<String> set = new HashSet<String>();  
		set.add(new String("±è»ñ°«"));       
		set.add(new String("È«±æµ¿"));       
		set.add(new String("ÃáÇâÀÌ"));        
		set.add(new String("ÀÌµµ·É"));       
		set.add(new String("Çâ´ÜÀÌ"));         
		System.out.println("HashSet : " + set);    
		TreeSet<String> ts = new TreeSet<String>(); 
		ts.addAll(set);          
		System.out.println("TreeSet : " + ts);  
	}
}