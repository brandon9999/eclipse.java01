/** TreeMap�� Comparator ���� **/

import java.util.*;  

class Score2
{    
	private int korea=0;   
	private int math=0;   
	
	public Score2(int korea, int math)
	{        
		this.korea = korea;    
		this.math = math;   
	}    
	
	public int getSum()
	{     
		return this.korea + this.math;   
	}    
	
	public String toString()
	{       
		return "����:" + korea + " ����:" + math;  
	} 
}

class MyComparator2<T> implements Comparator<T>
{      
	public int compare(T o1, T o2)
	{        
		Score s1 = (Score)o1;    
		Score s2 = (Score)o2;     
		int r = s1.getSum() - s2.getSum();  
		if(r>0)
		{       
			return 1; //�������� ����       
		}
		else if(r==0)
		{       
			return 0;           
		}
		else 
		{          
			return -1; //�������� ����         
		}   
	 }
}

public class TreeMapCompareTest
{     
	public static void main(String[] args)
	{        
		TreeMap<Score, String> tset = new TreeMap<Score, String>(new MyComparator2<Score>());      
		tset.put(new Score(21, 22), "ȫ�浿1");          
		tset.put(new Score(61, 62), "ȫ�浿2");       
		tset.put(new Score(81, 82), "ȫ�浿3");        
		tset.put(new Score(11, 12), "ȫ�浿4");         
		tset.put(new Score(31, 32), "ȫ�浿5");       
		System.out.println("TreeMap Sorting Example : " + tset);   
	} 
}