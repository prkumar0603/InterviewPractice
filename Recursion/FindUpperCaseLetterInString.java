package recursion;
/*Given a string find its first uppercase letter
Examples :
Input : geeksforgeeKs
Output : K
Input  : geekS
Output : S
*/
public class FindUpperCaseLetterInString {
    public static void main(String[] args) {
        String str = "geeksforgeeKs";
        firstUpperCase(str, str.length());
    }

    private static void firstUpperCase(String str, int n) {
        if (n == 0)
            return;

        firstUpperCase(str, n-1);
        if (Character.isUpperCase(str.charAt(n-1))){
            System.out.println(str.charAt(n-1));
        }

//        for (int i =0;i<n;i++){
//            if (Character.isUpperCase(str.charAt(i)))
//                return str.charAt(i);
//        }
//        return 0;
    }
}
