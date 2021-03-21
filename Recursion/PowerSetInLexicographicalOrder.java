package recursion;

import java.util.ArrayList;
import java.util.Collections;
/* generate power set in lexicographical order.
Examples :
Input : abc
Output : a ab abc ac b bc c
*/
public class PowerSetInLexicographicalOrder {
    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> alist = new ArrayList<>();
        generatePowerSet(str, "", alist);
        Collections.sort(alist);
        System.out.println(alist);
    }

    private static void generatePowerSet(String str, String out, ArrayList<String> alist) {
        // when input was becoming empty, then output had a subset.
        if(str.length() == 0){
            //System.out.print(out+" ");
            if (!out.equals(""))
            alist.add(out);
            return;
        }

        // tree was dividing into two part. one excluding the first character and other including it.
        String o1 = out;
        String o2 = out + str.charAt(0);

        // then we call the same function on both the inputs - o1  and o2 with the first character removed since
        // its decision was taken.
        generatePowerSet(str.substring(1), o1, alist);
        generatePowerSet(str.substring(1), o2, alist);

    }
}
/* concept from aditya verma tutorial of printing subset.
ArrayList is added to sort the list. on printing it was not in lexicographical order.
*/