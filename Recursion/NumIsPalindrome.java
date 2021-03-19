package recursion;

public class NumIsPalindrome {
    public static void main(String[] args) {
        int n = 2002;
        boolean res = checkIfPalindrome(n);
        System.out.println(res);
    }

    private static boolean checkIfPalindrome(int n) {
        int duplicate = n;
        int num = 0;

        while(n > 0){
            num = num * 10 + (n%10);
            n = n/10;
        }
        // System.out.println("rev ="+ num);

        return (duplicate== num);

    }
}
// simple approach is to reverse the number and compare