import java.io.*; 

public class FileCopy 
{     
	//FileCopy ���α׷��� ����     
	//java FileCopy ���������̸� ��ǥ�����̸�     
	//��) java FileCopy s.exe t.exe     
	//s.exe�� ���� ���͸� �� �����ؾ� �Ѵ�.     
	public static void main(String[] args) throws IOException
	{         
		int i, len=0;         
		FileInputStream fis = new FileInputStream(args[0]);          
		FileOutputStream fos = new FileOutputStream(args[1]);          
		long psecond = System.currentTimeMillis();          
		while((i=fis.read()) != -1) 
		{              
			fos.write(i);              
			len++;         
		}        
		fis.close();     
		fos.close();    
		psecond = System.currentTimeMillis() - psecond;           
		System.out.println(len + " bytes " + psecond +"  miliseconds");    
	} 
}