package recursion;

import java.util.Vector;
/* There are n people standing in a circle waiting to be executed. The counting out begins at some point in the circle and proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom. Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle. The task is to choose the place in the initial circle so that you are the last one remaining and so survive.

For example, if n = 5 and k = 2, then the safe position is 3. Firstly, the person at position 2 is killed, then person at position 4 is killed, then person at position 1 is killed. Finally, the person at position 5 is killed. So the person at position 3 survives. 

If n = 7 and k = 3, then the safe position is 4. The persons at positions 3, 6, 2, 7, 5, 1 are killed in order, and person at position 4 survives.
*/
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
