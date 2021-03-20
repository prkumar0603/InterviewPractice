package recursion;
/* Given an input string of numbers, find all combinations of numbers that can be formed using digits
in the same order.
Examples:
Input : 123
Output :1 2 3
        1 23
        12 3
        123
Input : 1234
Output : 1 2 3 4
        1 2 34
        1 23 4
        1 234
        12 3 4
        12 34
        123 4
        1234
*/
public class StringDigitCombination {
    public static void main(String[] args) {
        String n = "1234";
        printAll( n, "", 0);
    }

    private static void printAll(String str, String out, int i) {
        int n = str.length();

        if (n == i){
            System.out.print(out+" ");
            return;
        }

        for (int j=i;j<str.length();j++){
            printAll(str, out+" "+ str.substring(i, j+1), j+1);
        }
    }
}
