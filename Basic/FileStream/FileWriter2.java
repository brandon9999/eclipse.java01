import java.io.*; 

public class FileWriter2
{     
	public static void main(String[] args) throws IOException
	{         
		char[] content = new char[]{72, 101, 108, 108, 111};          
		String str = new String("Hello World!");          
		FileWriter fos = new FileWriter("D:\\temp3\\test2.txt");          
		fos.write(content); //���ڹ迭�� ���          
		fos.write(str); //���ڿ��� ���          
		fos.close();         
		System.out.println("test2.txt ���� ��� �Ϸ�");     
	}
}