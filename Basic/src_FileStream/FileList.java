import java.io.*; 

public class FileList
{     
	public static void main(String[] args)
	{         
		File f = new File("c:\\");          
		File[] fs = f.listFiles();          
		for(int i=0; i<fs.length; i++)
		{             
			System.out.println(fs[i].getName());          
		}     
	}  
} 