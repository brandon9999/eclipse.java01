/** Garbage Collector를 이용한 finalize()호출 I **/

import java.io.*;

class FinalMan
{     
	private FileWriter fw = null;   
	public FinalMan(String filename) throws IOException
	{       
		this.fw = new FileWriter(filename);   
	}    
	public void writeData(String str) throws IOException
	{       
		this.fw.write(str);      
		this.fw.flush();    
	}    
	protected void finalize() throws Throwable, IOException
	{          
		if (this.fw != null)
		{           
			this.fw.close();    
		}       
		System.out.println("finalize()의 파일 닫기");   
		super.finalize();     
	} 
}   

public class FinalManMain
{     
	public static void main(String[] args) throws Exception
	{        
		System.out.println("프로그램 시작"); 
		//단순블럭        
		{            
			FinalMan fm = new FinalMan("D:\\temp3\\test8.txt");   
			fm.writeData("안녕하세요");         
			fm.writeData("Hello");  
			fm = null;      
		}        
		System.gc();//가비지 콜렉터 구동   
		System.out.println("프로그램 종료");  
	}  
}