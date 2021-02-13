/*Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character. Note that after backspacing an empty text, the text will continue empty.
Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:
Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:
Input: S = ""bxj##tw"", T = "bxj###tw"
Output: false
Explanation: S becomes "btw" while T becomes "tw".
Note:
1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:
Can you solve it in O(N) time and O(1) space?
*/

import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        String S = "ab#c";
        String T = "ad#c";

        boolean res = backspaceCompare(S,T);
        System.out.println(res);
    }

    private static boolean backspaceCompare(String S, String T) {
	Stack<Character> p = new Stack<>();
    Stack<Character> q = new Stack<>();

        for (char c:s1.toCharArray()){
            if (c!='#'){
                p.push(c);
            }
            else{
                if (!p.isEmpty())
                    p.pop();
            }
        }

        for (char d:s2.toCharArray()){
            if (d!='#'){
                q.push(d);
            }
            else{
                if (!q.isEmpty())
                    q.pop();
            }
        }

        while(!p.isEmpty() && !q.isEmpty()){    // and means if any one is empty
            if (p.peek() == q.peek()){
                p.pop();
                q.pop();
            }
            else{
                return false;
            }
        }

        return (p.isEmpty() && q.isEmpty()); // imp. both should be empty at this time
    }
}
