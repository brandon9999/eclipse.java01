import java.io.*; 

public class  DirDelete
{     
	public static void main(String[] args) throws IOException
	{         
		File f = new File("D:\\temp3\\NewFolder");          
		if(f.exists())
		{              
			f.delete();              
			System.out.println("NewFolder ���͸��� ���� �Ϸ�");         
		}     
	}  
}  