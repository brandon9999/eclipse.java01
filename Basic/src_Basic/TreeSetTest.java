/** HashSet�� �̿��ؼ� TreeSet ���� **/

import java.util.*; 

public class TreeSetTest
{   
	public static void main(String args[]) 
	{         
		Set<String> set = new HashSet<String>();  
		set.add(new String("���"));       
		set.add(new String("ȫ�浿"));       
		set.add(new String("������"));        
		set.add(new String("�̵���"));       
		set.add(new String("�����"));         
		System.out.println("HashSet : " + set);    
		TreeSet<String> ts = new TreeSet<String>(); 
		ts.addAll(set);          
		System.out.println("TreeSet : " + ts);  
	}
}