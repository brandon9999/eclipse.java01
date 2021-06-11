/** InputStream을 BufferedReader로 변환 BufferedReader를 이용해서 줄 단위로 데이터 읽어내기 **/

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