import java.util.*;


/*
 * Hashtable�� Map interface�� implements �� Ŭ�����μ� �ߺ��� ������� �ʴ´�. 
Map�� Ư¡�� key�� value�� ������ �̷������, key �Ǵ� value �����ν� null�� ������� �ʴ´�.(HashMap���� ������) 
�Ʒ��� ���� HashTable�� ����� ������ �����̴�. import java.util.*;
 *
 * 
 * ����:java HashMapTest
���:
null
null
111
null
Hashtable size : 3
aaa value : 444
 */

public class HashtableTest

{

    public static void main(String argv[])
    {
    	//Hashtable ht = new Hashtable();
        Hashtable<String, String> ht = new Hashtable<String,String>();
        System.out.println(ht.put("aaa", "111"));
        System.out.println(ht.put("bbb", "222"));
        System.out.println(ht.put("aaa", "444"));
        System.out.println(ht.put("ccc", "333"));    
        
        System.out.println("Hashtable size : " + ht.size());
        
        System.out.println("aaa value : " + (String)ht.get("aaa"));
        
    }
}