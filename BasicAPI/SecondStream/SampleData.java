/** 진짜 객체 직렬화를 테스트하는 예제 **/

import java.io.*;  
class SampleData implements Serializable 
{      
	public String str;  
	public int id;  
	public SampleData(String str, int id)
	{       
		this.str = str;   
		this.id = id;   
	}  
	public String getSampleData()
	{       
		return id + "=" + str;   
	} 
}    