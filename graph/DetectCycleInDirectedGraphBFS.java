package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectedGraphBFS {
    private ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
    private int number_of_vertex;

    DetectCycleInDirectedGraphBFS(int V){
        number_of_vertex = V;
        for (int i=0;i<number_of_vertex;i++)
            alist.add(new ArrayList<>());
    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraphBFS obj = new DetectCycleInDirectedGraphBFS(5);

        /* obj.addEdge(0,1);
        obj.addEdge(0,3);
        obj.addEdge(1,2);
        obj.addEdge(2,3); */

        obj.addEdge(0,1);
        obj.addEdge(0,3);
        obj.addEdge(1,2);
        obj.addEdge(2,0);

        // obj.printList();
        boolean res = obj.isCyclic(0);
        System.out.println(res);
    }

    private boolean isCyclic(int s) {
        int[] indegree = new int[number_of_vertex];
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0;i<number_of_vertex;i++){
            for (int vertex : alist.get(i)){
                indegree[vertex]++;
            }
        }

        for (int i =0;i<number_of_vertex;i++){
            if (indegree[i] == 0)
                queue.add(i);
        }

        int count = queue.size();
        while(!queue.isEmpty()){
            int temp = queue.poll();
            // System.out.print(temp+" ");
            for (int vertex : alist.get(temp)){
                indegree[vertex]--;
                if (indegree[vertex] == 0) {
                    queue.add(vertex);
                    count++;
                }
            }
        }

        // count = numberOfVertex if all have indegree 0 after traversal
        if (count == number_of_vertex) return false;
        else return true;
    }

    private void addEdge(int u, int v) {
        alist.get(u).add(v);
    }

    private void printList() {
        for (int i=0;i<alist.size();i++){
            System.out.print("vertex -> "+ i);
            for (int j=0;j<alist.get(i).size();j++){
                System.out.print("-> "+ alist.get(i).get(j));
            }
            System.out.println();
        }
    }

}
/* Using topological sort*/