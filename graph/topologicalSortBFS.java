package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class topologicalSortBFS {
    private ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
    private int number_of_vertex;

    topologicalSortBFS(int V){
        number_of_vertex = V;
        for (int i=0;i<number_of_vertex;i++)
            alist.add(new ArrayList<>());

    }
    public static void main(String[] args) {
        topologicalSortBFS ts = new topologicalSortBFS(5);

        ts.addEdge(0,1);
        ts.addEdge(1,2);
        ts.addEdge(3,1);
        ts.addEdge(4,2);

        ts.printList();
        ts.topoSort();
    }

    private void topoSort() {
        int[] inDegree = new int[number_of_vertex];
        Queue<Integer> queue = new LinkedList<>();

        // finding the indegree of each vertex
        for (int i=0;i<number_of_vertex;i++){
            for (Integer vertex : alist.get(i)){
                inDegree[vertex]++;
            }
        }

        // System.out.println(Arrays.toString(inDegree));

        // vertex having zero indegree pushed to queue
        for (int i=0;i<number_of_vertex;i++){
            if (inDegree[i] == 0)
                queue.add(i);
        }

        // bfs
        while (!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp+" -> ");
            for (Integer vertex : alist.get(temp)){
                inDegree[vertex]--;     // since vertex removed, so indegree decreases
                if (inDegree[vertex] == 0){     // since indegree changes, verted having zero indegree, pushed to queue
                    queue.add(vertex);
                }
            }
        }

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
