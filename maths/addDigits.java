/* Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
Example 1:
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.

Example 2:
Input: num = 0
Output: 0

Constraints:
0 <= num <= 231 - 1
*/
public class addDigits {
    public static void main(String[] args) {
     int num = 38;
     int res = getSum(num);
     System.out.println(res);
    }
  
    public int getSum(int num) {
//         int sum =0;
//         while(num>0 || sum>9 ){
//             if(num == 0){
//                 num = sum;
//                 sum = 0;
//             }
                
//             sum += num%10;
//             num = num/10;
//         }
//         return sum;
        
        if(num == 0)
            return 0;
        
        return (num %9 == 0)? 9 : (num%9);
    }
}