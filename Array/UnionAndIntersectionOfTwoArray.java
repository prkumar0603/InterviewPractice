package Array;

public class UnionAndIntersectionOfTwoArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 7, 8};
        int[] arr2 = {2, 3, 5, 6};

        System.out.print("Union : ");
        printUnion(arr1, arr2);
        System.out.println();
        System.out.print("Intersection : ");
        printIntersection(arr1, arr2);
    }

    private static void printUnion(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int i = 0, j = 0;

        // run the loop, until pointer reaches end of any array.
        while (i < m && j < n) {

            // check smaller element, print it and increment the pointer.
            if (arr1[i] < arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
            } else if (arr1[i] > arr2[j]) {
                System.out.print(arr2[j] + " ");
                j++;
            } else {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }

        // print the remaining elements of the array
        while (i < m) {
            System.out.print(arr1[i] + " ");
            i++;
        }
        while (j < n) {
            System.out.print(arr2[j] + " ");
            j++;
        }
    }

    private static void printIntersection(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (arr1[i] == arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++; j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else
                j++;
        }
    }
}

/* Note : take two pointer. print whichever element is small and increment the pointer.
 * if both are same, print anyone and increment both .
 * lastly, print those elements, which are left from the larger array.
 * */
