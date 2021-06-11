/** �迭�� ���縦 ���� �����ϴ� �� **/

class ArrayParam 
{     
	//�迭 ���縦 ���� �޸𸮸� �޼��� ������ ����    
	public int[] copyArray(int[] src)
	{        
		int[] des = new int[src.length];		//���ο� �迭 ����     
		for(int i=0; i<src.length; i++)       
			des[i] = src[i]; //������       
		return des;     
	}     
	
	//�迭 ���縦 ���� �޸𸮸� �Ű������� ����    
	public void copyArray(int[] src, int[] des) 
	{         
		for(int i=0; i<src.length; i++)        
			des[i] = src[i]; //������   
	} 
}

public class ArrayParamTest
{
	public static void main(String[] args) 
	{        
		int[] source = new int[]{1,2,3,4,5}; //�迭 ����
		ArrayParam p = new ArrayParam(); //��ü ����    
		//1. copyArray(int[] src) ȣ��     
		int[] result = p.copyArray(source);  
		for(int i=0; i<result.length; i++)
		{          
			System.out.println("result["+i+"] : " + result[i]);      
		}       
		System.out.println();       
		//2. copyArray(int[] src, int[] des) ȣ��    
		int[] target = new int[source.length];   
		p.copyArray(source, target);       
		for(int i=0; i<target.length; i++)
		{       
			System.out.println("target["+i+"] : " + target[i]);  
		}  
	}
}