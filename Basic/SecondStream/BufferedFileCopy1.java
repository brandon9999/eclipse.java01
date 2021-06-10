/** Buffered ��Ʈ���� �̿��� ���� ���� ����(�� ����Ʈ ����) **/

import java.io.*; 

public class BufferedFileCopy1 
{    
	//BufferedFileCopy ���α׷��� ����   
	//java BufferedFileCopy ���������̸� ��ǥ�����̸�  
	//��) java BufferedFileCopy s.exe t.exe     
	//s.exe�� ���� ���͸� �� �����ؾ� �Ѵ�.  
	public static void main(String[] args) throws IOException
	{        
		int i, len=0;     
		FileInputStream fis = new FileInputStream(args[0]);     
		FileOutputStream fos = new FileOutputStream(args[1]);   
		BufferedInputStream bis = new BufferedInputStream(fis);    
		BufferedOutputStream bos = new BufferedOutputStream(fos);     
		long psecond = System.currentTimeMillis();         
		while((i=bis.read()) != -1) 
		{              
			bos.write(i);    
			len++;        
		}   
		bis.close();  
		bos.close();    
		psecond = System.currentTimeMillis() - psecond;
		System.out.println(len + " bytes " + psecond +" miliseconds");  
	} 
}