import java.io.*; 

public class DirMake
{     
	public static void main(String[] args) throws IOException
	{         
		File f = new File("D:\\temp3\\NewFolder");          
		if(!f.exists())
		{              
			f.mkdir();              
			System.out.println("NewFolder 디렉터리를 생성 완료");         
		}     
	}  
}  