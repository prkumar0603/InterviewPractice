package recursion;

public class RecursiveATOI {
    public static void main(String[] args) {
        String str = "125";
        int x = getATOI(str, str.length());
        System.out.println(x);
    }

    private static int getATOI(String str, int n) {
//        iterative
//        int res = 0;
//        for (int i =0;i<str.length();i++)
//            res = res*10 + (str.charAt(i) - '0');

        if (n == 1)
            return str.charAt(0) - '0';

        return (10 * (getATOI(str, n-1)) + str.charAt(n-1) - '0');
    }
}
/*Recursive approach - convert last digit to integer using iterative method and add rest digit
*/