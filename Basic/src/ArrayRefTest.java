/** �迭�� ������ �Ҵ��� �׽�Ʈ�ϴ� ���� **/

public class ArrayRefTest
{    
	public static void main(String[] args) 
	{        
		int[] aref  = new int[]{0,1,2,3};    
		int[] bref = aref;        
		int[] cref = bref;       
		//������ ���        
		System.out.println("aref=" + aref);    
		System.out.println("bref=" + bref);   
		System.out.println("cref=" + cref);  
		//aref[0]�� 10�� �Ҵ��� �� aref, bref, cref ����ϱ�    
		aref[0]=10;         
		for(int i=0; i<aref.length; i++) 
		{             
			System.out.print("aref[" + i + "]=" + aref[i] +"\t");     
			System.out.print("bref[" + i + "]=" + bref[i] +"\t");    
			System.out.println("cref[" + i + "]=" + cref[i]);  
		}      
		System.out.println();     
		//bref[1]�� 11�� �Ҵ��� �� aref, bref, cref ����ϱ�        
		bref[1] = 11;          
		for(int i=0; i<bref.length; i++) 
		{            
			System.out.print("aref[" + i + "]=" + aref[i] +"\t");        
			System.out.print("bref[" + i + "]=" + bref[i] +"\t");          
			System.out.println("cref[" + i + "]=" + cref[i]);     
		}        
		System.out.println();      
		//cref[2]�� 12�� �Ҵ��� �� aref, bref, cref ����ϱ�         
		cref[2] = 12;     
		for(int i=0; i<cref.length; i++)
		{         
			System.out.print("aref[" + i + "]=" + aref[i] +"\t");   
			System.out.print("bref[" + i + "]=" + bref[i] +"\t");        
			System.out.println("cref[" + i + "]=" + cref[i]);     
		} 
	}
}