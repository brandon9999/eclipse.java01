/** ����ƽ ��� �޼��忡�� �Ϲ� ��� ������ ����ϴ� ��(����) **/

public class StaticErr 
{   
	private int s;   
	//����ƽ ��� �޼��忡�� �Ϲ� ��� ���� ���(����)   
	public static void printStaticData()
	{        
		System.out.println(s); //����
	}    
	public static void main(String[] args)
	{       
		StaticErr.printStaticData();  
	}
}