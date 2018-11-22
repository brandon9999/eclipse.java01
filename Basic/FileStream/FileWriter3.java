import java.io.*; 

public class FileWriter3
{     
	public static void main(String[] args) throws IOException
	{         
		String str = new String("New Hello World!");          
		FileWriter fos = new FileWriter("D:\\temp3\\test2.txt", true);          
		fos.write(str);          
		fos.close();         
		System.out.println("test2.txt 에 덧붙여넣기 완료");     
	}  
} 