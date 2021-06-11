/** 미리 재정의된 Date의 toString() 라이브러리 차원에서 재정의되어 있는 toString() **/

import java.util.Date; 

public class DateMain
{   
	public static void main(String[] args)
	{       
		System.out.println(new Date());     
		System.out.println(new Date().toString()); 
	} 
} 