/** Vector 클래스의 기본적인 사용 **/

import java.util.Vector; 

public class VectorTest1
{   
	public static void main(String[] args)
	{       
		Vector<String> v = new Vector<String>(); //Vector 객체 생성    
		System.out.println("Vector 생성 직후의 size : " + v.size());     
		//1. 벡터에 데이터 4개 삽입    
		v.addElement(new String("망아지"));       
		v.addElement(new String("송아지"));  
		v.addElement(new String("강아지"));  
		v.addElement(new String("병아리"));    
		System.out.println("Vector에 데이터 삽입 후의 size : " + v.size());    
		//2. 벡터의 요소 출력하기        
		for(int i=0; i< v.size(); i++)
		{       
			//인덱스를 이용한 데이터 추출(다운캐스팅은 필수적)   
			String temp = v.elementAt(i);       
			System.out.println("Vector v의 " + i + "번째 :"  + temp);      
		} 
	}
}