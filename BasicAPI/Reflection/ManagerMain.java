/** action(Object obj)���� ��Ȯ���� �ʿ��� ��� **/

class Servant
{     
	public void cleaningHome()
	{        
		System.out.println("���� û�Ҹ� �մϴ�."); 
	}    
	
	public void washingCar()
	{       
		System.out.println("�����մϴ�.");    
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
		//�߸��� ���� �Ű������� �� ���        
		m.action(new Object());   
	}
}