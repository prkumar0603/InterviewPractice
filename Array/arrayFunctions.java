/*Some one liner for an array*/

import java.util.Arrays;

public class arrayFunctions {
    public static void main(String[] args) {

        int[] arr = {20,4,35,1,37};

        System.out.println("Minimum of Array = "+ Arrays.stream(arr).min().getAsInt());

        System.out.println("Maximun of Array = "+ Arrays.stream(arr).max().getAsInt());

        System.out.println("Print a 1D Array in one line = "+ Arrays.toString(arr));

        System.out.println("Print a 2D array in one line - Arrays.deepToString(array_name)");
	    
	int[][] two_dim_array = {{1,3},{15,18},{2,6},{8,10}};
        System.out.println("Sort an Array based on first value of each row");
        Arrays.sort(two_dim_array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];   //  o1[0] - o2[0]  for ascending
            }
        });
        System.out.println(Arrays.deepToString(two_dim_array));
	
	 
	List<String> alist = new ArrayList<>();
        alist.add("Convert");   alist.add("Arraylist"); alist.add("To");    alist.add("Array");
        String[] alist_to_array = alist.toArray(new String[alist.size()]);  // for class variables
        System.out.println(Arrays.toString(alist_to_array));

        List<Integer> alist1 = new ArrayList<>();
        alist1.add(1);
        alist1.add(2);
        int[] alist_to_array1 = alist1.stream().mapToInt(i->i).toArray();   // for primitive data types only
        System.out.println(Arrays.toString(alist_to_array1));
	    
	List<List<Integer>> li = new ArrayList<>();
	//li.add(new ArrayList<>(Arrays.asList(10)));
	li.add(new ArrayList<Integer>(){{add(10);}});
	System.out.println(li);
	
	
    }
}
