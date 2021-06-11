/** 정적 바인딩을 이용한 다운캐스팅 **/

class Data66
{    
	public void sayHello()
	{       
		System.out.println("Hello World!");
	} 
}    


public class StaticBindingMain
{    
	public static void main(String[] args)          throws InstantiationException, IllegalAccessException
	{     
		Class c = Data66.class; //정적 바인딩으로 Data 클래스의 사용 I      
		Object obj = c.newInstance();        
		Data66 d = (Data66)obj; //정적 바인딩으로 Data 클래스의 사용 II     
		Class c2 = d.getClass();        
		//정적 바인딩으로 Data 클래스의 사용 III     
		Data66 d2 = (Data66)c2.newInstance();        
		System.out.println(d);       
		System.out.println(d2);    
		d.sayHello();      
		d2.sayHello();    
	}
}