/** 스태틱 멤버 메서드에서 일반 멤버 변수를 사용하는 예(에러) **/

public class StaticErr 
{   
	private int s;   
	//스태틱 멤버 메서드에서 일반 멤버 변수 사용(에러)   
	public static void printStaticData()
	{        
		System.out.println(s); //에러
	}    
	public static void main(String[] args)
	{       
		StaticErr.printStaticData();  
	}
}