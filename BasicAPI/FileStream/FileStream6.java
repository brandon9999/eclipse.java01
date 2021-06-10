import java.io.*; 

public class FileStream6
{     
	public static void main(String[] args) throws IOException
	{         //1. 파일 사이즈 알아내기         
		File f = new File("D:\\temp3\\demo.f");          
		int fileSize = (int)f.length();           
		System.out.println("파일의 사이즈:" + fileSize);         
		//2. 파일 사이즈에 해당하는 배열 만들기         
		byte[] b = new byte[fileSize];          
		//3. 스트림을 이용해서 배열에 데이터 채우기         
		FileInputStream fis = new FileInputStream("D:\\temp3\\demo.f");          
		int pos = 0;         
		int size = 10;         
		int temp;         
		while((size=fis.read(b, pos, size)) > 0)
		{              
			pos += size;              
			temp = b.length - pos;             
			if(temp < 10)
			{                 
				size = temp;             
				}         
			}         
		fis.close();         
		System.out.println("읽은 바이트수:" + pos);         
		//4. 배열을 통째로 파일에 기록하기         
		FileOutputStream fos = new FileOutputStream("D:\\temp3\\test.txt");          
		fos.write(b);          
		fos.close();     
	}  
}
