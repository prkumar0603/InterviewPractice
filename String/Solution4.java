/*Problem Statement: Given a string, return the longest consecutive character and its length. For example, in string "AABCDDEBBBEA", return "B 3" since B occurs max for 3 consecutive times
Follow-Up question:     Do this in one pass, ie, in O(n).
Follow-Up question 2:   Do this without using additional space.
 */
import java.util.*;
public class Solution4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // AABCDDEBBBEA

        // aaaabbcbbb

        int max_count = 1;
        int curr_count = 1;
        char x='a';             // need to initialize else error
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i) == str.charAt(i+1))
            {
                curr_count++;
                // System.out.println(str.charAt(i)+" "+str.charAt(i+1));
                // System.out.println("Count = "+count);
            }
            else
            {
                if(curr_count > max_count)
                {
                    max_count = curr_count;
                    x = str.charAt(i);
                    //System.out.println("x = "+x);
                }

                curr_count = 1;
                // System.out.println(str.charAt(i+1));
                // System.out.println("max = "+max);
            }

        }

        System.out.println(x+" "+max_count);
        sc.close();

    }
}
/* Approach - iterate over the string. if (i)th character = (i+1)th character then count increases.
else restart count. */
