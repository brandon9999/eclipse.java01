/** ���� ���ε��� �̿��� �ٿ�ĳ���� **/

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
		Class c = Data66.class; //���� ���ε����� Data Ŭ������ ��� I      
		Object obj = c.newInstance();        
		Data66 d = (Data66)obj; //���� ���ε����� Data Ŭ������ ��� II     
		Class c2 = d.getClass();        
		//���� ���ε����� Data Ŭ������ ��� III     
		Data66 d2 = (Data66)c2.newInstance();        
		System.out.println(d);       
		System.out.println(d2);    
		d.sayHello();      
		d2.sayHello();    
	}
}