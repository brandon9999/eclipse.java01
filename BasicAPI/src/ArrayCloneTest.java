/** clone()을 이용한 메모리 차원의 배열복사 **/

public class ArrayCloneTest 
{    
	public static void main(String[] args)
	{        
		int[] source = new int[]{5, 4, 6, 9, 7, 9};       
		int[] target = (int[])source.clone(); //clone()을 이용한 메모리 복사    
		for(int i=0; i<target.length; i++)
		{             
			System.out.println("target["+i+"] : " + target[i]);      
		} 
	}
}