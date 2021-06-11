/** 클래스의 내의 정보 출력
 *  
 *  예제는 Integer 클래스의 등록정보를 Class c로 받아내고 있다.
 *  Integer 클래스는 java.lang 소속이기 때문에 자동으로 import가 된다.

 *  **/

import java.lang.reflect.*; 
import java.util.Vector; 

public class ShowClassInfoMain 
{         
	public static void main(String [] args) 
	{                 
		Class c = Integer.class;   
		Class[] iface = c.getInterfaces();  
		Constructor [] ctor = c.getConstructors();     
		Method [] m = c.getMethods();         
		Field[] f = c.getFields();         
		Class temp = c;         
		while( (temp=temp.getSuperclass()) != null )
		{                
			System.out.println(temp);   
		}         
		System.out.println();   
		for(int i=0; i<iface.length; i++)
		{         
			System.out.println("interface[" + i + "]:" + iface[i]);   
		}            
		System.out.println();      
		for(int i=0; i<ctor.length; i++)
		{        
			System.out.println("Constructor[" + i + "]:" + ctor[i]);
		}         
		System.out.println();   
		for(int i=0; i<m.length; i++)
		{                
			System.out.println("Method[" + i + "]:" + m[i]);  
		}            
		System.out.println();     
		for(int i=0; i<f.length; i++)
		{                
			System.out.println("Field[" + i + "]:" + f[i]);       
		}   
	} 
} 