/** InputStream�� BufferedReader�� ��ȯ BufferedReader�� �̿��ؼ� �� ������ ������ �о�� **/

import java.io.*;
public class BufferedReadLine1 
{     
	public static void main(String[] args) throws IOException
	{         
		int i, len=0;  
		InputStream in = System.in;     
		InputStreamReader isr = new InputStreamReader(in);  
		BufferedReader br = new BufferedReader(isr);         
		String temp;      
		if((temp=br.readLine())!= null )
		{          
			System.out.println(temp);   
		}   
	} 
}