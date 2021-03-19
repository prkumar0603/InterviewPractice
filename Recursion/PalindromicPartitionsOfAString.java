package recursion;

import java.util.ArrayList;

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

    private static void printAll(String str, String output, int i) {
        int n = str.length();
        if (i==n){
            System.out.println(output.substring(1));    // substring is added to remove first space
            return;
        }

        for (int j=i;j<n;j++){
            boolean val = palindrome(str,i, j);
            if (val)
                printAll(str, output + " "+ str.substring(i,j+1), j+1);
        }
    }

    private static boolean palindrome(String str, int i, int j) {
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