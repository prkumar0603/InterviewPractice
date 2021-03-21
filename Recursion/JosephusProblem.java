package recursion;

import java.util.Vector;

public class JosephusProblem {
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        Vector<Integer> vector = new Vector<>(n);   // creates a vectore of size n
        for (int i=1;i<=n;i++){
            vector.add(i);      // insert elements to vector
        }
        solve(vector, k-1, 0);
    }

    private static void solve(Vector<Integer> vector, int k, int start) {
        if (vector.size() == 1){
            System.out.println(vector.get(0));      // get is used to get element at particular index
            return;
        }

        start = (start + k) % vector.size();
        vector.remove(start);           // remove deletes element from vector

        solve(vector, k, start);
    }
}
/*Josephus( list , start , k){
   if list.size = 1     // if only one person remain, then return
       return list[0]

   start = (start + k) % list.size  // start denotes which element to delete. %list.size for remaining circular
   list.remove( start )
   return Josephus( list, start, k)
}*/