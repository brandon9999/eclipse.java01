/** Vector Ŭ������ �⺻���� ��� **/

import java.util.Vector; 

public class VectorTest1
{   
	public static void main(String[] args)
	{       
		Vector<String> v = new Vector<String>(); //Vector ��ü ����    
		System.out.println("Vector ���� ������ size : " + v.size());     
		//1. ���Ϳ� ������ 4�� ����    
		v.addElement(new String("������"));       
		v.addElement(new String("�۾���"));  
		v.addElement(new String("������"));  
		v.addElement(new String("���Ƹ�"));    
		System.out.println("Vector�� ������ ���� ���� size : " + v.size());    
		//2. ������ ��� ����ϱ�        
		for(int i=0; i< v.size(); i++)
		{       
			//�ε����� �̿��� ������ ����(�ٿ�ĳ������ �ʼ���)   
			String temp = v.elementAt(i);       
			System.out.println("Vector v�� " + i + "��° :"  + temp);      
		} 
	}
}