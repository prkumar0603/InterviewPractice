import java.util.HashMap;
import java.util.Map;

public class hashmapFunction {
    public static void main(String[] args) {
        HashMap<Character,Integer> map = new HashMap<>();

        map.put('A',65);
        map.put('a',97);

        String s = "Hello World";
        for (char x:s.toCharArray()) {
            if (x!=32)  //32 is the ascii of space
            map.put(x, map.getOrDefault(x, 0) + 1);
            // map.getOrDefault(key_whose_value_is_to_be_fetched, default_value)
        }
        System.out.println(map);

        // to iterate over a HashMap
        for(Integer i:map.keySet()){
            System.out.println(i+"->"+map.get(i));
        }
        
        // 2nd method
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()){
            int key = (int)it.next();
            System.out.println(key+" - "+map.get(key));
        }
        // 3rd method
        for (Map.Entry<Character,Integer> e:map.entrySet())
            System.out.println(e.getKey()+" "+e.getValue());

        if (map.containsKey('A'))
            System.out.println("value of A = "+map.get('A'));
    }
}
