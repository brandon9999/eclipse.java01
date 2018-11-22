/** �پ��� Vector�� �޼��带 �׽�Ʈ�ϴ� �� **/

import java.util.Vector;

public class VectorTest2 
{   
	public static void main(String[] args)
	{        
		Vector<Object> v = new Vector<Object>(); //��ü ����     
		//Vector v�� ��ü����   
		v.addElement(new Character('A')); //Wrapper Ŭ������ ���    
		v.addElement(new String("������"));      
		v.addElement(new Integer(100)); //Wrapper Ŭ������ ���  
		v.addElement(new Integer(200)); //Wrapper Ŭ������ ���       
		System.out.println("Vector�� size():" + v.size());     
		//1��°�� �߰�����, 1��°�� �ִ� �����ʹ� 2��°�� �ȴ�.     
		v.insertElementAt(new Float(3.141592), 1);      
		System.out.println("insertElementAt()-size():" + v.size());     
		//3��° �����ϴ� �����͸� ����     
		v.setElementAt("Hello", 3);   
		System.out.println("setElement()-size():" + v.size());  
		//������ ������ Ÿ���� �ٸ��� ������ �ϳ��� ������ �� ����ȯ �� ���      
		System.out.println("v��0��°:" + (Character)v.elementAt(0));   
		System.out.println("v��1��°:" + (Float)v.elementAt(1));       
		System.out.println("v��2��°:" + (String)v.elementAt(2));      
		System.out.println("v��3��°:" + (String)v.elementAt(3));      
		System.out.println("v��4��°:" + (Integer)v.elementAt(4));     
		//"Hello" �˻�     
		if(v.contains("Hello"))
		{ 
			//�����Ͱ� �ִ��� Ȯ��      
			int find = v.indexOf("Hello"); //������ ��ġ Ȯ��        
			//��ġ(�ε���)�� �̿��� �������� ����         
			System.out.println("v��" + find + "��°:" + (String)v.elementAt(find));      
		} 
	}
}