import java.io.*; 

public class FileRename
{     
	public static void main(String[] args) throws IOException
	{         
		File f = new File("D:\\temp3\\license.dat");          
		File t = new File("D:\\temp3\\license.dat.rename");          
		if(f.exists())
		{              
			f.renameTo(t);              
			System.out.println("�̸��ٲٱ� �Ϸ�");             
			System.out.print("license.dat->");             
			System.out.println("license.dat.rename");         
		}     
	}  
}  