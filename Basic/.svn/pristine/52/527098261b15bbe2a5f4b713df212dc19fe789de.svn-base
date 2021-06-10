import java.io.*; 

public class FileStream3
{     
	public static void main(String[] args) throws IOException
	{         
		File f = new File("D:\\temp3\\a.txt");          
		if(f.exists())
		{              
			FileOutputStream fos = new FileOutputStream("D:\\temp3\\a.txt", true);             
			byte[] b = new byte[]{72, 101, 108, 108, 111};              
			fos.write(b);              
			fos.close();             
			System.out.println("a.dat 파일의 끝부분에 데이터 추가하기 완료");         
		}     
	}  
} 