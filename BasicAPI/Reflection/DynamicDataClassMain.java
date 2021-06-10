/** ���� ���ε� Ŭ������ �׽�Ʈ�ϴ� �� **/

import java.io.*; 
import java.net.*;

public class DynamicDataClassMain
{    
	public static void main(String[] args) throws IOException,          InstantiationException, IllegalAccessException, ClassNotFoundException
	{       
		System.out.println("�ٿ�ε���....");    
		URL url = new URL("http://www.jabook.org/DynamicData.class");    
		InputStream is = url.openStream();    
		FileOutputStream fos = new FileOutputStream("DynamicData.class");     
		int i;       
		while((i=is.read()) != -1)
		{           
			fos.write(i);          
			System.out.print("|");       
		}     
		fos.close();  
		is.close();     
		System.out.println("\n�ٿ�ε� �Ϸ�...");       
		//���α׷��� �������� ������ DynamicData.class ������ ���ÿ� �������� �ʴ´�.      
		Class c = Class.forName("DynamicData");        
		Object obj = c.newInstance();         
		System.out.println(obj);   
	}
}