/** Ŭ������ ���� ���� ���
 *  
 *  ������ Integer Ŭ������ ��������� Class c�� �޾Ƴ��� �ִ�.
 *  Integer Ŭ������ java.lang �Ҽ��̱� ������ �ڵ����� import�� �ȴ�.

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