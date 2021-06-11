/** 바이트 스트림으로 문자를 핸들할 때 발생하는 문제를 보여주는 예제 **/

public class InputStream1
{   
	public static void main(String[] args) throws java.io.IOException 
	{    
		int i;      
		System.out.println("종료하기 위해서는 '끝'을 입력하시오");    
		System.out.println("출력할 데이터를 입력하시오? ");    
		while((i=System.in.read()) != '끝') 
		{           
			System.out.print((char)i);  
		}   
	}
} 