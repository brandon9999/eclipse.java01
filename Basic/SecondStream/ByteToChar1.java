/** ����Ʈ ��Ʈ���� ���� ��Ʈ������ ��ȯ�ϴ� ���� **/

import java.io.*; 

public class ByteToChar1
{     
	//ByteToCharMain ���α׷��� ����    
	//java ByteToCharMain ���������̸� ��ǥ�����̸�     
	//��) java ByteToCharMain ByteToCharMain.java tmp.txt     
	public static void main (String[] args) throws IOException
	{        
		FileInputStream fis = new FileInputStream (args[0]);   
		FileOutputStream fos = new FileOutputStream (args[1]);     
		InputStreamReader isr = new InputStreamReader (fis);     
		OutputStreamWriter osw = new OutputStreamWriter (fos);       
		int i;        
		while((i=isr.read()) != -1)
		{          
			osw.write(i);     
		}      
		osw.close();       
		isr.close();     
		System.out.println("�۾��Ϸ�");  
	} 
}