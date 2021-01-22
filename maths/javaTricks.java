//To use BigInteger must import below one.
import java.math.BigInteger;
public class javaTricks {

	public static void main(String[] args) {
  
        // every prime number can be represented in the form of 6n+1 or 6n-1 except 2 and 3.

        // finding number of digits in a number
             int num = 536870912;
             System.out.println(Math.floor(Math.log10(num)+1));


        // get digit sum until it is single digit number
             int sum =0;
             if (num==0)
                 sum = 0;
             else
                 sum = (num%9==0)? 9 : (num%9);

             System.out.println("sum = "+sum);


        // String match function
             String str = "11111";
             System.out.print(str.matches("(.*)101(.*)"));

        // convert a character to UPPERCASE
             System.out.println("To Uppercase a character = "+ Character.toUpperCase('a'));


        //Base Change Program. All data type have base 10only. converting to base 16.
             int x = 145;

             BigInteger br = new BigInteger(x+"",10);//10 is the initial base of input or default base
             String s = br.toString(16);//16 is the base into which converted

             System.out.println(s);
        
	}
	
}
