/** Class�� �̿��� ��ü ���� **/

class Data7
{   
	//... 
}  

public class UserDataClassMain
{   
	public static void main(String[] args) throws InstantiationException, IllegalAccessException
	{        
		Class c = Data7.class;    
		Object obj = c.newInstance();     
		System.out.println(obj);    
	} 
}
