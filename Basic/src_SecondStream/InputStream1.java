/** ����Ʈ ��Ʈ������ ���ڸ� �ڵ��� �� �߻��ϴ� ������ �����ִ� ���� **/

public class InputStream1
{   
	public static void main(String[] args) throws java.io.IOException 
	{    
		int i;      
		System.out.println("�����ϱ� ���ؼ��� '��'�� �Է��Ͻÿ�");    
		System.out.println("����� �����͸� �Է��Ͻÿ�? ");    
		while((i=System.in.read()) != '��') 
		{           
			System.out.print((char)i);  
		}   
	}
} 