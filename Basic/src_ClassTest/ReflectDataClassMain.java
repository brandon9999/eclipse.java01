/** getClass()�� �̿��� Class ��� **/

class Data8
{     
	//������� 
}   

public class ReflectDataClassMain
{   public static void main(String[] args)          throws InstantiationException, IllegalAccessException
	{
		Data8 d = new Data8();      
		Class c = d.getClass();       
		Object obj = c.newInstance();     
		System.out.println(obj); 
	}  
}