import java.io.*; 

public class SystemIn
{     
	public static void main(String[] args) throws IOException
	{         
		System.out.print("���ڸ� �Է��� �� ���͸� ��������");         
		int i;
		while((i=System.in.read()) != '\n')
		{
			System.out.println((char)i +":" + i);
		}
	}  
}  