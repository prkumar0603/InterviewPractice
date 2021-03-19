package recursion;

public class DemoRec {
    public static void main (String[] args){
//        int n = 5;
//        int res = fact(n);
//        System.out.println(res);

//        int n = 9987;
//        int res = numSum(n);
//        System.out.println(res);

        int n = 5;
        int a=2,b=5,c=1;
        int res = getMaxCount(n, a,b,c);
        System.out.println(res);

    }

    // max count on rod cutting problem
    private static int getMaxCount(int n, int a, int b, int c) {
        if (n == 0)
            return 0;

        if (n < 0)
            return -1;

        int res =  Math.max(getMaxCount(n-a, a, b, c ), Math.max(
                getMaxCount(n-b, a, c, b ), getMaxCount(n-c, a, b, c ) ));

        if (res == -1)
            return -1;

        return res + 1;
    }

    // sum of numbers using recursion
    public static int numSum(int n){
        if (n < 10)
            return n;

        return (numSum(n/10) + n%10);
    }

    // factorial using recursion
    public static int fact(int n){
        if (n == 0)
            return 1;

        return n * fact(n-1);
    }
}
