/*Problem Statement : Find the nth number of the series. Series is a defined as
sum of unique powers of 5 starting from 1.
5 , 25 , 30(5+25) , 125 , 130(125+5) , 150(125+25) , 155(125+25+5)......
Follow-Up Question 1: Use Constant Space ie, no extra array
Follow-Up Question 2: Try doing it in O(log n)
*/
class magicNumber
{
    public static void main (String[] args)
    {
        int n = 5;
        int pow = 1,answer = 0;

        while(n!=0){
            pow = pow*5;
            //System.out.println("pow = "+pow);

            if((int)(n & 1) == 1){		// cheks whether last digit of n is 1 or 0. if 1 then add to answer else leave
                //System.out.println("n & 1 = "+ (n&1));
                answer += pow;
                //System.out.println("answer = "+answer);
            }

            n >>= 1;		//proceed to next bit   n = 10 = 2
            //System.out.println("n = "+n);

        }
        System.out.println("answer = "+answer);
    }

}
/*the magic numbers can be represented as 001, 010, 011, 100, 101, 110 etc, where 001 is
0*pow(5,3) + 0*pow(5,2) + 1*pow(5,1). So basically we need to add powers of 5 for each
bit set in given integer n*/