/** ���� ��Ʈ���� �̿��� �����ذ� **/

import java.io.*; 

public class InputStreamReader1
{  
	public static void main(String[] args) throws java.io.IOException 
	{      
		int i;   
		InputStreamReader isr = new InputStreamReader(System.in);    
		System.out.println("�����ϱ� ���ؼ��� '��'�� �Է��Ͻÿ�");    
		System.out.println("����� �����͸� �Է��Ͻÿ�? ");        
		while((i=isr.read()) != '��') 
		{           
			System.out.print((char)i);   
		} 
	}  
}  