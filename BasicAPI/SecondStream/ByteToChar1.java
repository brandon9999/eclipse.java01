/** 바이트 스트림을 문자 스트림으로 변환하는 예제 **/

import java.io.*; 

public class ByteToChar1
{     
	//ByteToCharMain 프로그램의 실행    
	//java ByteToCharMain 원본파일이름 목표파일이름     
	//예) java ByteToCharMain ByteToCharMain.java tmp.txt     
	public static void main (String[] args) throws IOException
	{        
		FileInputStream fis = new FileInputStream (args[0]);   
		FileOutputStream fos = new FileOutputStream (args[1]);     
		InputStreamReader isr = new InputStreamReader (fis);     
		OutputStreamWriter osw = new OutputStreamWriter (fos);       
		int i;        
		while((i=isr.read()) != -1)
		{          
			osw.write(i);     
		}      
		osw.close();       
		isr.close();     
		System.out.println("작업완료");  
	} 
}