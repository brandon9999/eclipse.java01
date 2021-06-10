/** action(Object obj)에서 형확인을 추가한 경우 **/

class Servant2
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

class Manager2
{      
	public void action(Object obj)
	{         
		if(obj instanceof Servant2)
		{        
			System.out.println("당신은 Servant군요!");   
			Servant2 d = (Servant2)obj;            
			d.cleaningHome();           
			d.washingCar();        
		}
		else
		{  
			System.out.println("당신은 Servant가 아니군요!");  
		}    
	}
}   

public class ManagerMain2
{    
	public static void main(String[] args)
	{        
		Manager2 m = new Manager2();   
		m.action(new Object()); //잘못된 형을 매개변수로 준 경우         
		m.action(new Servant2()); //제대로된 형을 매개변수로 준 경우   
	}
}