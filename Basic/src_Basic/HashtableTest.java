import java.util.*;


/*
 * Hashtable은 Map interface를 implements 한 클래스로서 중복을 허용하지 않는다. 
Map의 특징인 key와 value의 쌍으로 이루어지며, key 또는 value 값으로써 null을 허용하지 않는다.(HashMap과의 차이점) 
아래의 예는 HashTable을 사용한 간단한 예제이다. import java.util.*;
 *
 * 
 * 실행:java HashMapTest
결과:
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