/** TreeMap의 Comparator 구현 **/

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
		return "국어:" + korea + " 수학:" + math;  
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
			return 1; //오름차순 정렬       
		}
		else if(r==0)
		{       
			return 0;           
		}
		else 
		{          
			return -1; //내림차운 정렬         
		}   
	 }
}

public class TreeMapCompareTest
{     
	public static void main(String[] args)
	{        
		TreeMap<Score, String> tset = new TreeMap<Score, String>(new MyComparator2<Score>());      
		tset.put(new Score(21, 22), "홍길동1");          
		tset.put(new Score(61, 62), "홍길동2");       
		tset.put(new Score(81, 82), "홍길동3");        
		tset.put(new Score(11, 12), "홍길동4");         
		tset.put(new Score(31, 32), "홍길동5");       
		System.out.println("TreeMap Sorting Example : " + tset);   
	} 
}