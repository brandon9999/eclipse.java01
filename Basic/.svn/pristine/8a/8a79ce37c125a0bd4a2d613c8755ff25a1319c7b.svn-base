/** action(Object obj)에서 형확인이 필요한 경우 **/

class Servant
{     
	public void cleaningHome()
	{        
		System.out.println("집안 청소를 합니다."); 
	}    
	
	public void washingCar()
	{       
		System.out.println("세차합니다.");    
	} 
}

class Manager
{     
	public void action(Object obj)
	{        
		Servant d = (Servant)obj;   
		d.cleaningHome();     
		d.washingCar();   
	} 
}   

public class ManagerMain
{    
	public static void main(String[] args)
	{        
		Manager m = new Manager();     
		//잘못된 형을 매개변수로 준 경우        
		m.action(new Object());   
	}
}