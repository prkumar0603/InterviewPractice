package recursion;
/* print all permutation of a string.
Example
Input - ABC
Output - ABC ACB BAC BCA CBA CAB
*/
public class PermutationOfString {
    public static void main(String[] args) {
        String str = "ABC";
        permute(str, str.length(), 0);
    }

    private static void permute(String str, int n, int start) {
        if (n == start+1){
            System.out.print(str+" ");
            return;
        }
        else{
            for (int i=start;i<n;i++){
                str = swap(str, start, i);
                solve(str, n, start+1);
                str = swap(str, start, i);
            }
        }
    }

    private static String swap(String str, int i, int j) {
        char[] s = str.toCharArray();
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        return String.valueOf(s);
    }
}
/*we swap characters in the string to generate all permutations.
and then do backtracking after the recursion call for earlier position of characters.
*/
