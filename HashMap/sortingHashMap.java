import java.util.*;

/* Given marks scored out of 100 by a student in subjects where name of the subject is key and marks
scored is the value. Our task is to sort the hashmap according to values i.e. according to marks.
Example:
Input : Key = Math, Value = 98
        Key = Data Structure, Value = 85
        Key = Database, Value = 91
        Key = Java, Value = 95
        Key = Operating System, Value = 79
        Key = Networking, Value = 80
Output : Key = Operating System, Value = 79
         Key = Networking, Value = 80
         Key = Data Structure, Value = 85
         Key = Database, Value = 91
         Key = Java, Value = 95
         Key = Math, Value = 98
*/
public class sortingHashMap {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Math", 98);
        map.put("Data Structure", 85);
        map.put("Database", 91);
        map.put("Java", 95);
        map.put("Operating System", 79);
        map.put("Networking", 80);
        
        HashMap<String,Integer> res = sortByValue(map);
        for (String i : res.keySet()){
            System.out.println(i+"->"+res.get(i));
        }
    }

    private static HashMap<String, Integer> sortByValue(HashMap<String, Integer> map) {
        // we will sort HashMap using Collections.sort function. But we cannot put HashMap in Collections.sort method.
        // so we will convert HashMap to List and sort and then convert back to HashMap

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // System.out.println(list);

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue() - o2.getValue());
            }
        });

        // System.out.println(list);
        HashMap<String, Integer> hm = new LinkedHashMap<>();
        // LinkedHashMap is same as hashmap which maintain order of elements inserted into it.
        for (Map.Entry<String,Integer> aa : list){
            hm.put(aa.getKey(), aa.getValue());
        }

        return hm;
    }
}
