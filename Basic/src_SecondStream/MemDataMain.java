/** ��ü�� ������ ���Ͽ� ������ �� �ٽ� �����ϱ� **/

public class MemDataMain
{    
	public static void main(String[] args) throws java.io.IOException
	{       
		MemData m = new MemData();    
		m.setMemData(100, 200000, 3.14159F);  
		System.out.println(m.toString() + " : " + m.getMemData());      
		m.saveMemData("D:\\temp3\\test5.txt"); //���Ͽ� ��ü ����       
		MemData r = MemData.restoreMemData("D:\\temp3\\test5.txt"); //���Ϸκ��� ���� 
        System.out.println(r.toString() + " : " + r.getMemData());     
	}
}