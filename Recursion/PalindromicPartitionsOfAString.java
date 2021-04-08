package recursion;
/*
Given a string, find all possible palindromic partitions of given string.
Example
Input : nitin
Output : n i t i n
        n iti n
        nitin

Input : geeks
Output : g e e k s
        g ee k s
*/
public class PalindromicPartitionsOfAString {
    public static void main(String[] args) {
        String str = "geeks";
        printAll(str, "", 0);
    }

    private static void printAll(String str, String output, int start) {
        int n = str.length();
        if (start == n){
            System.out.println(output.substring(1));    // substring is added to remove first space
            return;
        }

        for (int i=start; i < n; i++){
            boolean val = palin(str,start, i);
            if (val)
                printAll(str, output + " "+ str.substring(start,i+1), i+1);
        }
    }

    private static boolean palin(String str, int i, int j) {
        while(i < j){
            if (str.charAt(i) != str.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }
}

// we can take a variable to store output. no need to create a static arraylist
