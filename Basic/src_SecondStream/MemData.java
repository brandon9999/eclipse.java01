/** 수작업으로 직렬화 구현하기 **/

import java.io.*;

public class MemData
{     
	private int id;  
	private long type;    
	private float weight;    
	public void setMemData(int id, long type, float weight)
	{         
		this.id = id;  
		this.type = type;       
		this.weight = weight;    
		}  
	public String getMemData()
	{        
		return id + ", " + type + ", " + weight;   
	}   
	public void saveMemData(String filename) throws IOException
	{       
		FileWriter fw = new FileWriter(filename);   
		BufferedWriter bw = new BufferedWriter(fw);       
		bw.write("MemData\n");      
		bw.write(id + "\n");    
		bw.write(type + "\n");      
		bw.write(weight + "\n");       
		bw.close();       
	}  
	public static MemData restoreMemData(String filename) throws IOException
	{        
		FileReader fr = new FileReader(filename);   
		BufferedReader br = new BufferedReader(fr);  
		String temp = br.readLine();        
		MemData memObj = new MemData();      
		if(temp.equals("MemData"))
		{        
			int i = Integer.parseInt(br.readLine());    
			long t = Long.parseLong(br.readLine());      
			float w = Float.parseFloat(br.readLine());     
			memObj.setMemData(i, t, w);        
		}      
		br.close();   
		return memObj;  
	} 
} 