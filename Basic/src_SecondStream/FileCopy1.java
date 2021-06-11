/** File 스트림을 이용한 파일 복사 예제(한 바이트 단위) **/

import java.io.*; 

public class FileCopy1 
{    
	//FileCopy 프로그램의 실행 
	//java FileCopy 원본파일이름 목표파일이름    
	//예) java FileCopy s.exe t.exe    
	//s.exe는 같은 디렉터리 상에 존재해야 한다.    
	public static void main(String[] args) throws IOException
	{         
		int i, len=0;     
		FileInputStream fis = new FileInputStream(args[0]);   
		FileOutputStream fos = new FileOutputStream(args[1]);    
		long psecond = System.currentTimeMillis();        
		while((i=fis.read()) != -1) 
		{              
			fos.write(i);     
			len++;        
		}        
		fis.close();        
		fos.close();     
		psecond = System.currentTimeMillis() - psecond;   
		System.out.println(len + " bytes " + psecond +"  miliseconds"); 
	}
}