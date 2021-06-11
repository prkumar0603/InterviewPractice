/* Print all subsequence of the given String.
Input : abc
Output : a, b, c, ab, bc, ac, abc

Input : aaa
Output : a, aa, aaa

Input : abcd
Output : abcd, abc, abd, ab, acd, ac, ad, a, bcd, bc, bd, b, cd, c, d,

*/

public class printSubSequence {
    public static void main(String[] args) {
        String str = "abcd";
        int len = str.length();

        String res[] = findSubSequence(str);
        for (String arr:res){
            System.out.println(arr);
        }

    }

    private static String[] findSubSequence(String str) {
        if (str.length() == 0) {
            String[] ans = {""};
            return ans;
        }

        // calling subsequence on lesser part of string
        String[] smallAns = findSubSequence(str.substring(1));

        // now add the new character with answers from previous.
        // create twice size array.
        String[] ans = new String[2 * smallAns.length];

        // add all from small input.
        for (int i=0;i<smallAns.length;i++){
            ans[i] = smallAns[i];
        }

        // add the first character in each output
        for (int i=0;i< smallAns.length;i++){
            ans[i+ smallAns.length] = str.charAt(0) + smallAns[i];
        }

        return ans;
    }
    
    
    // printing all subsequence of a string
    private static void printAllSubSeq(String str, String out) {
        if (str.length() == 0){
            System.out.println(out);
            return;
        }

        // add the first character in answer
        printAllSubSeq(str.substring(1), out + str.charAt(0));

        // not adding first character in answer
        printAllSubSeq(str.substring(1), out);
    }
    
}
/* explanation from coding ninja video */
