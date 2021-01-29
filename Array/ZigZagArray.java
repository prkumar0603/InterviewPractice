import java.util.Arrays;

/*Convert a normal array into a zigzag array. Eg. - array = [5,10,8,12,6,9,4]
 * The elements form a zigzag form. 5<10, 10>8, 8<12, 12>6, 6<9, 9>4 . Elements follow < , > order alternatively.
 * if a=5, b=10, c=8, d=12 then a < b > c and b > c < d.
 */
public class ZigZagArray {
    static int arr[] = {4, 3, 7, 8, 6, 2, 1};
    public static void main(String[] args) {

        System.out.println("Initial Array = "+Arrays.toString(arr));

        boolean flag = true;
        for (int i=0; i<arr.length-1; i++){

            if(flag){			//if flag = true then i<i+1 (if not then swap)
                if(arr[i]>arr[i+1]){
                    swap(i);
                }
            }

            else{				//if flag = false then i>i+1 (if not then swap)
                if(arr[i]<arr[i+1]){
                    swap(i);
                }
            }

            //System.out.println("=> "+Arrays.toString(arr));
            flag = !(flag);
        }

        System.out.println("Final Array = "+Arrays.toString(arr));
    }

    private static void swap(int i) {
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
    }
}
/* keep first element in place. initialize a flag as false.
    if flag = 0  implies  i < i+1
    if flag = 1  implies  i > i+1
    if these condition are not, then swap
*/