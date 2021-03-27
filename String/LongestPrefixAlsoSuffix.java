package String;
/* Given a string s, find length of the longest prefix which is also suffix.
The prefix and suffix should not overlap.
Examples:
Input : aabcdaabc
Output : 4
The string "aabc" is the longest
prefix which is also suffix.
Input : abcab
Output : 2
Input : aaaa
Output : 2
*/
public class LongestPrefixAlsoSuffix {
    public static void main(String[] args) {
        String str = "aabcdaabc";
        int res = getLengthOfPrefixAndSuffix(str);
        System.out.println(res);
    }

    /*break the string from middle and start matching left and right string.
    If they are equal return size of any one string else try for shorter lengths on both sides.*/
    private static int getLengthOfPrefixAndSuffix(String str) {
        int n = str.length();

        // if n is less than 2
        if (n < 2)
            return 0;

        int len = 0;
        int i = (n+1)/2;

        while(i < n){
            if (str.charAt(i) == str.charAt(len)){
                len++;
                i++;
            }else{
                i = i - len +1;
                len=0;
            }
        }

        return len;
    }
}
