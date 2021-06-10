import java.io.*; 

public class FileStream2
{     
	public static void main(String[] args) throws IOException
	{         
		FileOutputStream fos = new FileOutputStream("D:\\temp3\\a2.txt");          
		byte[] b = new byte[]{72, 101, 108, 108, 111};          
		fos.write(b);          
		fos.close();         
		System.out.println("a1.dat 파일 기록완료");     
	}  
}