/** Data ��Ʈ���� �׽�Ʈ�ϴ� ���� **/

import java.io.*; 

public class DataInputOutput1
{
	public static void main(String[] args) throws IOException
	{        
		//DataOutputStream�� �̿��ؼ� ������ Ÿ�� ������ ������ ����ϱ�   
		FileOutputStream fos = new FileOutputStream("D:\\temp3\\test2.txt");   
		DataOutputStream dos = new DataOutputStream(fos);   
		dos.write(100);		//byte������ ����ϱ�(1����Ʈ)       
		dos.writeInt(100);		//int������ ����ϱ�(4����Ʈ)   
		dos.writeFloat(3.14f);		//float������ ����ϱ�(4����Ʈ)     
		dos.writeChar('A'); 		//char������ ����ϱ�(2����Ʈ)    
		dos.close();        
		//DataInputStream�� �̿��ؼ� ������ Ÿ�� ������ ������ �о����      
		FileInputStream fis = new FileInputStream("D:\\temp3\\test2.txt");    
		DataInputStream dis = new DataInputStream(fis);      
		int i = dis.read(); 		//1����Ʈ �б�  
		int i2 = dis.readInt();		//4����Ʈ �б�        
		float f = dis.readFloat(); //4����Ʈ�� float�������� �б�        
		char c = dis.readChar();    //2����Ʈ �б�       
		dis.close();        
		System.out.println( i + "," + i2 + "," + f + "," + c);   
	} 
}