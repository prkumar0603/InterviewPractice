/* Print all non-empty Substring of the given String
Input :  abcd
Output :  a
          b
          c
          d
          ab
          bc
          cd
          abc
          bcd
          abcd
*/

public class printSubString {
    public static void main(String[] args) {
        String str = "abcd";
        int len = str.length();

        for (int i=0;i<len;i++){
            for (int j=i+1;j<=len;j++){
                System.out.println(str.substring(i,j));
            }
        }

    }
}
