package recursion;
/* Given a string calculate length of the string using recursion.
Examples:
Input : str = "abcd"
Output :4
Input : str = "GEEKSFORGEEKS"
Output :13
*/
public class LengthOfString {
    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";
        int res = getLen(str);
        System.out.println(res);
    }

    private static int getLen(String str) {
        if (str.equals("")) // since we are checking empty string so only "equals" function works
            return 0;
        else
            return 1 + getLen(str.substring(1));
    }
}
