/** getClass()를 이용한 Class 얻기 **/

class Data8
{     
	//내용없음 
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