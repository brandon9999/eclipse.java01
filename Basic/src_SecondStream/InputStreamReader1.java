/** 문자 스트림을 이용한 문제해결 **/

import java.io.*; 

public class InputStreamReader1
{  
	public static void main(String[] args) throws java.io.IOException 
	{      
		int i;   
		InputStreamReader isr = new InputStreamReader(System.in);    
		System.out.println("종료하기 위해서는 '끝'을 입력하시오");    
		System.out.println("출력할 데이터를 입력하시오? ");        
		while((i=isr.read()) != '끝') 
		{           
			System.out.print((char)i);   
		} 
	}  
}  