package BinarySearch;

class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,12,14,16,18,19,20};
        int k = 1;
        int res = BinSearchIter(arr, k);
        if (res == -1)
            System.out.println("element not found");
        else
            System.out.println("element found at "+(int)(res+1));

        int res1 = BinSearchRec(arr, 0, arr.length-1, k);
        if (res1 == -1)
            System.out.println("element not found");
        else
            System.out.println("element found at "+(int)(res1+1));
    }

    private static int BinSearchRec(int[] arr, int low, int high, int k) {
        if (low == high){
            if (arr[0] == k)
                return arr[0];
            else
                return -1;
        }
        else {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k)
                return mid;
            else if (arr[mid] < k)
                return BinSearchRec(arr, mid+1, high, k);
            else
                return BinSearchRec(arr, low, mid-1, k);
        }

    }

    private static int BinSearchIter(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if (arr[mid] == k)
                return mid;

            // if k is greater, ignore left half
            else if (arr[mid] < k)
                low = mid + 1;

            else
                high = mid -1;
        }
        return -1;
    }

}
