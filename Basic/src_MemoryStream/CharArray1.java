/** CharArray ��Ʈ���� �̿��� ���� �迭 �ٷ�� **/

import java.io.*; 

public class CharArray1
{     
	public static void main(String[] args) throws IOException 
	{      
		int ch;       
		char[] arr = {'j','a','b','o','o','k'};        
		CharArrayReader car = new CharArrayReader(arr);     
		CharArrayWriter caw = new CharArrayWriter();         
		while((ch=car.read()) != -1) 
		{             
			caw.write(ch);     
		}       
		String str = caw.toString();     
		System.out.println(str); 
		//jabook ���        
		//������    
		char[] result = caw.toCharArray();      
		for(int i=0; i<result.length; i++)
		{           
			System.out.print(result[i]);
			//jabook ���      
		}        
		car.close();     
		caw.close();  
	} 
}