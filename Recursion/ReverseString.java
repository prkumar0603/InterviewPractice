package recursion;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello";
        String res = getReverse(str, str.length());
        System.out.println(res);
    }

    private static String getReverse(String str, int n) {
        if (str == null || n == 0)
            return "";

        return str.charAt(n-1) + getReverse(str, n-1);
    }
}
// take out the last character and add it with others.