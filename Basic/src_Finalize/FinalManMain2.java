/** 메서드가 속한 스레드의 정보 출력 Garbage를 이용한 finalize()호출 II **/

import java.io.*; 

class FinalMan2
{    
	private FileWriter fr = null;  
	public FinalMan2(String filename) throws IOException
	{       
		fr = new FileWriter(filename);   
	}    
	public void writeData(String str) throws IOException
	{        
		this.fr.write(str);  
	}    
	protected void finalize() throws Throwable, IOException
	{        
		//finalize()가 속한 스레드의 정보 출력     
		Thread t = Thread.currentThread();    
		System.out.println("finalize()의 스레드: " + t );      
		if (fr != null)
		{          
			fr.close();   
		}        
		System.out.println("finalize()의 파일 닫기");      
		super.finalize();  
	}  
}    

public class FinalManMain2
{     
	public static void main(String[] args) throws Exception
	{        
		System.out.println("프로그램 시작");  
		{          
			FinalMan2 fm = new FinalMan2("D:\\temp3\\bbb.txt");       
			fm.writeData("안녕하세요");          
			fm.writeData("Hello");        
			fm = null;       
		}      
		//main()이 속한 스레드의 정보 출력      
		Thread t = Thread.currentThread();    
		System.out.println("main()의 스레드: " + t );     
		System.gc(); //수동으로 가비지 콜렉터 구동시키기      
		System.out.println("프로그램 종료"); 
	}
}