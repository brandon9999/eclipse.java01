import java.io.*;

public class SampleDataMain
{   
	public static void main(String[] args)          throws IOException, ClassNotFoundException
	{         //1. Á÷·ÄÈ­(Serialization)      
		FileOutputStream fos = new FileOutputStream("D:\\temp3\\test7.txt");    
		ObjectOutputStream oos = new ObjectOutputStream(fos);     
		SampleData s1 = new SampleData("È«±æµ¿", 1004);   
		SampleData s2 = new SampleData("±è»ñ°«", 1005);     
		oos.writeObject(s1);    
		oos.writeObject(s2);      
		oos.close();       
		System.out.println(s1 + ":" + s1.getSampleData());  
		System.out.println(s2 + ":" + s2.getSampleData());    
		//¿ªÁ÷·ÄÈ­(Deserialization)       
		FileInputStream fis = new FileInputStream("D:\\temp3\\test7.txt");    
		ObjectInputStream ois = new ObjectInputStream(fis);  
       SampleData sd1 = (SampleData)ois.readObject();   
       SampleData sd2 = (SampleData)ois.readObject();        
       ois.close();       
       System.out.println(sd1 + ":" + sd1.getSampleData());   
       System.out.println(sd2 + ":" + sd2.getSampleData());    
	}
}