package recursion;

public class PermutationOfString {
    public static void main(String[] args) {
        String str = "ABC";
        permute(str, str.length(), 0);
    }

    private static void permute(String str, int n, int i) {
        if (n == i+1){
            System.out.print(str+" ");
            return;
        }
        else{
            for (int j=i;j<n;j++){
                String s = swap(str, i, j);
                permute(s, n, i+1);
                s = swap(str, i, j);
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