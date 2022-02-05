package Array;

/* Write a program to reverse an array */

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        // maximum and minimum of an array
        System.out.println("maximum : " + Arrays.stream(arr).max());
        System.out.println("maximum : " + Arrays.stream(arr).max().getAsInt());
        System.out.println("minimum : " + Arrays.stream(arr).min().getAsInt());

        // Array Reversal using swapping
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
