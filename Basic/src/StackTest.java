/** Stack Ŭ������ ��� **/

import java.util.*; 

public class StackTest
{     
	public static void main(String[] args)
	{        
		Stack<String> stack = new Stack<String>();   
		System.out.println(stack.empty());    
		stack.push(new String("jabook"));          
		stack.push(new String("java"));          
		stack.push(new String("�Ҽ����� �ڹ�"));   
		System.out.println(stack.empty());         
		System.out.println(stack.peek());      
		System.out.println(stack.pop());        
		System.out.println(stack.peek());        
		System.out.println(stack.search("jabook"));   
	}  
} 