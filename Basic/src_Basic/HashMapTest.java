import java.util.*;

/*
 * HashMap은 Map interface를 implements 한 클래스로서 중복을 허용하지 않는다. 
Map의 특징인 key와 value의 쌍으로 이루어지며, key 또는 value 값으로써 null을 허용한다. 
아래의 예는 HashMap을 사용한 간단한 예제이다.
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
