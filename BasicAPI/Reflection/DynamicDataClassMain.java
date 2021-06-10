/** 동적 바인딩 클래스를 테스트하는 예 **/

import java.io.*; 
import java.net.*;

public class DynamicDataClassMain
{    
	public static void main(String[] args) throws IOException,          InstantiationException, IllegalAccessException, ClassNotFoundException
	{       
		System.out.println("다운로드중....");    
		URL url = new URL("http://www.jabook.org/DynamicData.class");    
		InputStream is = url.openStream();    
		FileOutputStream fos = new FileOutputStream("DynamicData.class");     
		int i;       
		while((i=is.read()) != -1)
		{           
			fos.write(i);          
			System.out.print("|");       
		}     
		fos.close();  
		is.close();     
		System.out.println("\n다운로드 완료...");       
		//프로그램을 컴파일할 때에는 DynamicData.class 파일이 로컬에 존재하지 않는다.      
		Class c = Class.forName("DynamicData");        
		Object obj = c.newInstance();         
		System.out.println(obj);   
	}
}