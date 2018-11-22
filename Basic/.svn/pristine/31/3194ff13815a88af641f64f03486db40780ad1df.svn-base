import java.io.*; 

public class FileStream5
{     
	public static void main(String[] args) throws IOException
	{         
		FileInputStream fis = new FileInputStream("D:\\temp3\\demo.f");          
		int count;         
		byte[] b = new byte[10];          
		while( (count=fis.read(b)) != -1 )
		{              
			for(int i=0; i<count; i++)
			{                 
				System.out.print((char)b[i]);             
			}         
		}         
		fis.close();     
	}  
} 