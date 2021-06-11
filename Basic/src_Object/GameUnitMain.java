/** equals()를 재정의해서 사용자 정의 비교법을 테스트하는 예제 **/

class GameUnit extends Object 
{     
	private int id;    
	private String name;    
	public GameUnit(int id, String name)
	{        
		this.id = id;     
		this.name = name;   
	}   
	public int getId() 
	{        
		return this.id;  
	}    
	public String getName()
	{         
		return this.name;  
	}  
	public boolean equals(Object obj) 
	{     
		if(obj instanceof GameUnit)
		{      
			GameUnit eo =(GameUnit)obj;       
			return (this.id == eo.id);    
		}       
		return false; 
	}    
	public String toString()
	{        
		return id + ":" + name;   
	} 
}    

public class GameUnitMain 
{    
	public static void main(String[] args) 
	{        
		GameUnit e1 = new GameUnit(1000, "Tank");   
		GameUnit e2 = new GameUnit(1000, "Missile" );      
		System.out.println("e1: " + e1);      
		System.out.println("e2: " + e2);      
		System.out.println("e1.hashCode(): " + e1.hashCode());    
		System.out.println("e2.hashCode(): " + e2.hashCode());     
		System.out.println("e1==e2: "+(e1==e2));        
		System.out.println("e1.equals(e2): "+ e1.equals(e2));   
	} 
}  