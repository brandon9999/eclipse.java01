/** String 스트림을 사용하는 예 **/

import java.io.*; 

public class StringStream1
{ 
	public static void main(String[] args) throws IOException 
	{        
		int ch;   
		String str = "Hello!";   
		StringReader sr = new StringReader(str);     
		StringWriter sw = new StringWriter();      
		while((ch=sr.read()) != -1) 
		{            
			sw.write(ch);       
		}        
		String result = sw.toString();     
		System.out.println(result);        
		StringBuffer sb = sw.getBuffer(); 
		System.out.println(sb.toString());  
	}  
} 