/** Vector���� Enumeration�� �׽�Ʈ�ϴ� �� **/

import java.util.*;

public class EnumVector
{     
	public static void main(String[] args) 
	{       
		Vector<String> v = new Vector<String>(); 
		//vector�� ������ 4�� ����      
		v.addElement(new String("������"));       
		v.addElement(new String("�۾���"));         
		v.addElement(new String("������"));          
		v.addElement(new String("���Ƹ�"));         
		//Enumeration�� �̿��� ������ ���     
		Enumeration<String> en = v.elements();    
		while(en.hasMoreElements())
		{
			//Vector�� �����Ͱ� �����ϴ��� �˻�          
			//Vector���� ������ ����(�ٿ�ĳ���� �ʿ�)     
			String temp = en.nextElement();    
			System.out.println(temp);       
		} 
	}
}