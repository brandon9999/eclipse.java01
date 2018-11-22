/** Data 스트림을 테스트하는 예제 **/

import java.io.*; 

public class DataInputOutput1
{
	public static void main(String[] args) throws IOException
	{        
		//DataOutputStream을 이용해서 데이터 타입 단위로 데이터 기록하기   
		FileOutputStream fos = new FileOutputStream("D:\\temp3\\test2.txt");   
		DataOutputStream dos = new DataOutputStream(fos);   
		dos.write(100);		//byte형으로 기록하기(1바이트)       
		dos.writeInt(100);		//int형으로 기록하기(4바이트)   
		dos.writeFloat(3.14f);		//float형으로 기록하기(4바이트)     
		dos.writeChar('A'); 		//char형으로 기록하기(2바이트)    
		dos.close();        
		//DataInputStream을 이용해서 데이터 타입 단위로 데이터 읽어오기      
		FileInputStream fis = new FileInputStream("D:\\temp3\\test2.txt");    
		DataInputStream dis = new DataInputStream(fis);      
		int i = dis.read(); 		//1바이트 읽기  
		int i2 = dis.readInt();		//4바이트 읽기        
		float f = dis.readFloat(); //4바이트를 float형식으로 읽기        
		char c = dis.readChar();    //2바이트 읽기       
		dis.close();        
		System.out.println( i + "," + i2 + "," + f + "," + c);   
	} 
}