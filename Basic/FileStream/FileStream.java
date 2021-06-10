import java.io.*; 

public class FileStream
{     
	public static void main(String[] args) throws IOException
	{         
		FileOutputStream fos = new FileOutputStream("D:\\temp3\\a.txt");          
		fos.write(72);          
		fos.write(101);          
		fos.write(108);          
		fos.write(108);          
		fos.write(111);          
		fos.close();         
		System.out.println("a.txt 파일 기록완료");     
	}  
}