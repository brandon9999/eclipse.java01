/** �޼��尡 ���� �������� ���� ��� Garbage�� �̿��� finalize()ȣ�� II **/

import java.io.*; 

class FinalMan2
{    
	private FileWriter fr = null;  
	public FinalMan2(String filename) throws IOException
	{       
		fr = new FileWriter(filename);   
	}    
	public void writeData(String str) throws IOException
	{        
		this.fr.write(str);  
	}    
	protected void finalize() throws Throwable, IOException
	{        
		//finalize()�� ���� �������� ���� ���     
		Thread t = Thread.currentThread();    
		System.out.println("finalize()�� ������: " + t );      
		if (fr != null)
		{          
			fr.close();   
		}        
		System.out.println("finalize()�� ���� �ݱ�");      
		super.finalize();  
	}  
}    

public class FinalManMain2
{     
	public static void main(String[] args) throws Exception
	{        
		System.out.println("���α׷� ����");  
		{          
			FinalMan2 fm = new FinalMan2("D:\\temp3\\bbb.txt");       
			fm.writeData("�ȳ��ϼ���");          
			fm.writeData("Hello");        
			fm = null;       
		}      
		//main()�� ���� �������� ���� ���      
		Thread t = Thread.currentThread();    
		System.out.println("main()�� ������: " + t );     
		System.gc(); //�������� ������ �ݷ��� ������Ű��      
		System.out.println("���α׷� ����"); 
	}
}