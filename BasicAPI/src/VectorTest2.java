/** 다양한 Vector의 메서드를 테스트하는 예 **/

import java.util.Vector;

public class VectorTest2 
{   
	public static void main(String[] args)
	{        
		Vector<Object> v = new Vector<Object>(); //객체 생성     
		//Vector v에 객체삽입   
		v.addElement(new Character('A')); //Wrapper 클래스의 사용    
		v.addElement(new String("굼뱅이"));      
		v.addElement(new Integer(100)); //Wrapper 클래스의 사용  
		v.addElement(new Integer(200)); //Wrapper 클래스의 사용       
		System.out.println("Vector의 size():" + v.size());     
		//1번째에 중간삽입, 1번째에 있던 데이터는 2번째가 된다.     
		v.insertElementAt(new Float(3.141592), 1);      
		System.out.println("insertElementAt()-size():" + v.size());     
		//3번째 존재하는 데이터를 수정     
		v.setElementAt("Hello", 3);   
		System.out.println("setElement()-size():" + v.size());  
		//삽입한 데이터 타입이 다르기 때문에 하나씩 추출한 뒤 형변환 후 사용      
		System.out.println("v의0번째:" + (Character)v.elementAt(0));   
		System.out.println("v의1번째:" + (Float)v.elementAt(1));       
		System.out.println("v의2번째:" + (String)v.elementAt(2));      
		System.out.println("v의3번째:" + (String)v.elementAt(3));      
		System.out.println("v의4번째:" + (Integer)v.elementAt(4));     
		//"Hello" 검색     
		if(v.contains("Hello"))
		{ 
			//데이터가 있는지 확인      
			int find = v.indexOf("Hello"); //데이터 위치 확인        
			//위치(인덱스)를 이용한 데이터의 추출         
			System.out.println("v의" + find + "번째:" + (String)v.elementAt(find));      
		} 
	}
}