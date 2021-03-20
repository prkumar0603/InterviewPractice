package recursion;
/* Given a string, count total number of consonants in it. A consonant is a English
alphabet character that is not vowel (a, e, i, o and u). Examples of constants are b, c, d, f, g, ..
Examples :
Input : abc de
Output : 3
There are three consonants b, c and d.
Input : geeksforgeeks portal
Output : 12
*/
public class CountConsonentInString {
    public static void main(String[] args) {
        String str = "geeksforgeeks portal";
        int res = getConsonentCount(str, str.length());
        System.out.println(res);
    }

    private static int getConsonentCount(String str, int n) {
        if (n==0){
            return 0;
        }

        int out =  getConsonentCount(str, n-1);
        char x = Character.toLowerCase(str.charAt(n-1));
        if ( x != 'a' && x != 'e' && x != 'i' && x != 'o' && x != 'u' && x>=97 && x <= 122 )
            return out + 1;
        else
            return out;
    }
}
/* Checking the last character and getting the rest from recursion.
*/