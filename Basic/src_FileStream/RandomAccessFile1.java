/** 임의 접근방식으로 파일 접근-RandomAccessFile을 테스트하는 예제 **/

import java.io.*; public class

RandomAccessFile1
{     
	public static void main(String[] args) throws IOException
	{         
		String s = "I love normal java";         
		String q = "jabook";         
		RandomAccessFile rf = new RandomAccessFile("D:\\temp3\\test2.txt", "rw");          
		rf.writeBytes(s);          
		rf.close();        
		RandomAccessFile rf2 = new RandomAccessFile("D:\\temp3\\test2.txt", "rw");       
		rf2.seek(7);       
		rf2.writeBytes(q);        
		rf2.close();      
		RandomAccessFile rf3 = new RandomAccessFile("D:\\temp3\\test2.txt", "r");          
		rf3.seek(2);       
		System.out.println(rf3.readLine());    
		rf3.close();    
	} 
}  