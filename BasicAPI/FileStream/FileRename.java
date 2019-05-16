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
			System.out.println("이름바꾸기 완료");             
			System.out.print("license.dat->");             
			System.out.println("license.dat.rename");         
		}     
	}  
}  