/** ����Ʈ �迭 ��Ʈ���� �׽�Ʈ�ϴ� �� **/

import java.io.*; 

public class ByteArrayStream1
{     
	public static void main(String[] args) throws IOException 
	{         
		int i;         
		byte[] arr = {'j', 'a', 'b', 'o', 'o', 'k'};          
		//1. ByteArray ��Ʈ�� ����       
		ByteArrayInputStream in = new ByteArrayInputStream(arr);       
		ByteArrayOutputStream out = new ByteArrayOutputStream();     
		//2. ByteArrayInputStream���� �а� ByteArrayOutputStream�� ���      
		while((i=in.read()) != -1)
		{             
			out.write(i);     
		}        
		//3. ByteArrayOutputStream���κ��� ����Ʈ �迭 ���      
		byte[] result = out.toByteArray();     
		for(i=0; i<result.length; i++)
		{        
			System.out.print((char)result[i]);       
		}       
		in.close();    
		out.close();   
	} 
}