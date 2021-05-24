package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class graphCreation {
    static ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
    public static void main(String[] args) {
        // create a weighted graph
        /*
        int[][] graph = new int[][] {{0,1,0,1,0,0,0,0},
                                    {1,0,1,0,0,0,0,0},
                                    {0,1,0,0,0,0,0,0},
                                    {1,0,0,0,1,0,0,1},
                                    {0,0,0,1,0,1,1,1},
                                    {0,0,0,0,1,0,1,0},
                                    {0,0,0,0,1,1,0,1},
                                    {0,0,0,1,1,0,1,0}};

        System.out.println(Arrays.deepToString(graph));
        */

        // for unweighted graph
        int number_of_vertex = 8;

        for (int i=0;i<number_of_vertex;i++){   // adding that much arrayList
            alist.add(new ArrayList<>());
        }

        addEdge(0,1);
        addEdge(0,3);
        addEdge(1,2);
        addEdge(3,4);
        addEdge(3,7);
        addEdge(4,5);
        addEdge(4,6);
        addEdge(4,7);
        addEdge(5,6);
        addEdge(6,7);
        
        printList();

    }

    private static void printList() {
        for (int i=0;i<alist.size();i++){
            System.out.print("vertex -> "+ i);
            for (int j=0;j<alist.get(i).size();j++){
                System.out.print("-> "+ alist.get(i).get(j));
            }
            System.out.println();
        }
    }

    private static void addEdge(int i, int j) {
        alist.get(i).add(j);
        alist.get(j).add(i);
    }
}
/*Note - for weighted graph - make a 2D array.
        for un-weighted graph -
        make an arraylist - static ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
*/
