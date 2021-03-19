package recursion;

/*
Given an integer K. Task is Print All binary string of size K (Given number) which do not
have consecutive 1's.
Examples:

Input : K = 3
Output : 000 , 001 , 010 , 100 , 101

Input : K  = 4
Output :0000 0001 0010 0100 0101 1000 1001 1010
*/

public class BinaryStringWithoutConsecutiveOne {
    public static void main(String[] args) {
        int k = 3;
        printAllString("",k);
    }

    private static void printAllString(String out,int k) {
        if (k <= 0)
            return;

        out = "0";
        generate(out, k, 0);
        out = "1";
        generate(out, k, 0);

    }

    private static void generate(String out, int k, int n) {
        if (k == n+1){
            System.out.print(out+ " ");
            return;
        }

        if (out.charAt(n) == '0'){
            generate(out+"0", k, n+1);
            generate(out+"1", k, n+1);
        }
        else{
            generate(out+"0", k, n+1);
        }
    }
}
/* K : size of string
First We Generate All string starts with '0'
initialize n = 0 .
GenerateALLString ( K  , Str , n )
  a. IF n+1 == K
     PRINT str.
  b. IF previous character is '1' :: str[n-1] == '1'
     put str[n] = '0'
     GenerateAllString ( K , str , n+1 )
  c. IF previous character is '0' :: str[n-1] == '0'
     First We Put zero at end and call function
      PUT  str[n] = '0'
           GenerateAllString ( K , str , n+1 )
      PUT  str[n] = '1'
           GenerateAllString ( K , str , n+1 )

Second Generate all binary string starts with '1'
DO THE SAME PROCESS
*/