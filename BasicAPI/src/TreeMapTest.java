import java.util.*;


/*
 * TreeMap역시 중복을 허용하지 않으며, key와 value의 쌍으로 이루어져 있다. 
HashMap과 다른 점은 SortedMap을 implements 하였으므로, key 값들에 대한 정렬이 이루어진다는 점이다. 
아래의 예는 TreeMap을 사용하여 각 요소가 몇몇 이나 나왔는지 알아보는 간단한 예제이다.


실행:java TreeMapTest if it is to be it is up to me to delegate
결과:
8 distinct words detected:
{be=1, delegate=1, if=1, is=2, it=2, me=1, to=3, up=1}
 */

public class TreeMapTest

{
    private static final Integer ONE = new Integer(1);

    public static void main(String args[])

    {
        Map m = new TreeMap();

        // Initialize frequency table from command line
        for (int i=0; i < args.length; i++)

        {
            Integer freq = (Integer) m.get(args[i]);
            m.put(args[i], (freq==null ? ONE :
                            new Integer(freq.intValue() + 1)));
        }

        System.out.println(m.size()+" distinct words detected:");
        System.out.println(m);
    }
}