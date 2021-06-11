/** 객체의 정보를 파일에 저장한 후 다시 복원하기 **/

public class MemDataMain
{    
	public static void main(String[] args) throws java.io.IOException
	{       
		MemData m = new MemData();    
		m.setMemData(100, 200000, 3.14159F);  
		System.out.println(m.toString() + " : " + m.getMemData());      
		m.saveMemData("D:\\temp3\\test5.txt"); //파일에 객체 저장       
		MemData r = MemData.restoreMemData("D:\\temp3\\test5.txt"); //파일로부터 복원 
        System.out.println(r.toString() + " : " + r.getMemData());     
	}
}