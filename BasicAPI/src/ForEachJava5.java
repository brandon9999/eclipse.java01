/** Advanced for��(for each��)�� ��� **/

import java.util.*; 

public class ForEachJava5
{   
	public static void main(String[] args)
	{        
		ArrayList<String> ar = new ArrayList<String>();  
		ar.add("�ȳ�1");      
		ar.add("�ȳ�2");    
		ar.add("�ȳ�3");    
		//1. �Ϲ����� For��      
		for (Iterator<String> i = ar.iterator(); i.hasNext(); ) 
		{              
			String tmp = i.next();              
			System.out.println(tmp);         
		}        
		//2. For Each�� J2SE 5.0�� �ڵ�         
		for (String tmp : ar)
		{             
			System.out.println(tmp);     
		}    
	}
}