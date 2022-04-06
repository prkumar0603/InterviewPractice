package Array;

/*Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
Note: can you take care of the duplicates without using any additional Data Structure?
Example 1:
Input:
n1 = 6; A = {1, 5, 10, 20, 40, 80}
n2 = 5; B = {6, 7, 20, 80, 100}
n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20 80
Explanation: 20 and 80 are the only
common elements in A, B and C.*/

public class CommonElements {
    public static void main(String[] args) {
/*      int A[] = {3,3,3};
        int B[] = {3,3,3};
        int C[] = {3,3,3};*/

        int A[] = {1, 5, 10, 20, 40, 80};
        int B[] = {6, 7, 20, 80, 100};
        int C[] = {3, 4, 15, 20, 30, 70, 80, 120};

        
        int i = 0, j = 0, k = 0;
        int n1=A.length;
        int n2=B.length;
        int n3=C.length;

        int prev1,prev2,prev3;
        prev1 = prev2 = prev3 = Integer. MIN_VALUE;

        while (i < n1 && j < n2 && k < n3) {

            // if A array has dupes
            while (i<n1 && A[i] == prev1) i++;

            // if B array has dupes
            while (j<n2 && B[j] == prev2) j++;

            // if C array has dupes
            while (k<n3 && C[k] == prev3) k++;


            if (i<n1 && j<n2 && k<n3){
                if (A[i] == B[j] && B[j]==C[k]) {
                    System.out.println(A[i]);
                    // first store the element and then increment
                    prev1 = A[i]; prev2 = B[j]; prev3 = C[k];
                    i++; j++;k++;
                } else if (A[i] < B[j]) {
                    prev1 = A[i];
                    i++;
                } else if (B[j] < C[k]) {
                    prev2 = B[j];
                    j++;
                } else {
                    prev3 = C[k];
                    k++;
                }
            }

        }
        

    }
}

/* check for 2 array and similarly expand for 3rd array. 
* for duplicates, store the previous element, and if it matches, then increment. */
