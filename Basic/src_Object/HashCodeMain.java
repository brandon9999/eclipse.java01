/** 해시코드를 출력하는 예제 **/

class HashMan
{    
	//내용없음
}   

public class HashCodeMain 
{     
	public static void main(String[] args)
	{        
		HashMan h1 = new HashMan();   
		HashMan h2 = new HashMan();          
		System.out.println(h1 + ": " + h1.hashCode());   
		System.out.println(h2 + ": " + h2.hashCode()); 
	}
}