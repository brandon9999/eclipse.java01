/** 배열의 참조값 할당을 테스트하는 예제 **/

public class ArrayRefTest
{    
	public static void main(String[] args) 
	{        
		int[] aref  = new int[]{0,1,2,3};    
		int[] bref = aref;        
		int[] cref = bref;       
		//참조값 출력        
		System.out.println("aref=" + aref);    
		System.out.println("bref=" + bref);   
		System.out.println("cref=" + cref);  
		//aref[0]에 10을 할당한 후 aref, bref, cref 출력하기    
		aref[0]=10;         
		for(int i=0; i<aref.length; i++) 
		{             
			System.out.print("aref[" + i + "]=" + aref[i] +"\t");     
			System.out.print("bref[" + i + "]=" + bref[i] +"\t");    
			System.out.println("cref[" + i + "]=" + cref[i]);  
		}      
		System.out.println();     
		//bref[1]에 11을 할당한 후 aref, bref, cref 출력하기        
		bref[1] = 11;          
		for(int i=0; i<bref.length; i++) 
		{            
			System.out.print("aref[" + i + "]=" + aref[i] +"\t");        
			System.out.print("bref[" + i + "]=" + bref[i] +"\t");          
			System.out.println("cref[" + i + "]=" + cref[i]);     
		}        
		System.out.println();      
		//cref[2]에 12을 할당한 후 aref, bref, cref 출력하기         
		cref[2] = 12;     
		for(int i=0; i<cref.length; i++)
		{         
			System.out.print("aref[" + i + "]=" + aref[i] +"\t");   
			System.out.print("bref[" + i + "]=" + bref[i] +"\t");        
			System.out.println("cref[" + i + "]=" + cref[i]);     
		} 
	}
}