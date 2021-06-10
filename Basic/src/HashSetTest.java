/** HashSet Ŭ������ ��� **/

import java.util.*; 

public class HashSetTest
{      
	public static void main(String args[])
	{         
		Set<String> set = new HashSet<String>();    
		set.add("���");     
		set.add("ȫ�浿");       
		set.add("������");       
		set.add("�̵���");         
		set.add("�����");         
		System.out.println("HashSet : " + set);      
		set.remove("�̵���");       
		System.out.println(set.contains("ȫ�浿"));    
		Iterator<String> iter = set.iterator();        
		
		while(iter.hasNext())
		{            
			String temp = iter.next();    
			System.out.print(temp + ", ");     
		}         
		System.out.println();  
	}   
} 