import java.util.*;

/*
 * HashMap�� Map interface�� implements �� Ŭ�����μ� �ߺ��� ������� �ʴ´�. 
Map�� Ư¡�� key�� value�� ������ �̷������, key �Ǵ� value �����ν� null�� ����Ѵ�. 
�Ʒ��� ���� HashMap�� ����� ������ �����̴�.
 */

public class HashMapTest
{
    public static void main(String argv[])
    {
		String query="a";
        for(int i = 0; i < 10; i++)
        {
			query=query+"a";
		}
    	
        //HashMap hm = new HashMap();
    	HashMap<Integer,String> hm = new HashMap<Integer,String>();
    	
        for(int i = 0; i < 10; i++)
        {
			hm.put(new Integer(i), query);
        }
        
        System.out.println("HashMap size : " + hm.size());
        
        Set set = hm.keySet();
        Object []hmKeys = set.toArray();
        for(int i = 0; i < hmKeys.length; i++)
        {
			String key = String.valueOf(hmKeys[i]);  
            System.out.print(key);
            System.out.print(" - ");
            System.out.println(hm.get(i));
            
        }
        
    }
}
