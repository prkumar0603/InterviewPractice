package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class topologicalSortDFS {
    private ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
    private int number_of_vertex;

    topologicalSortDFS(int V){
        number_of_vertex = V;
        for (int i=0;i<number_of_vertex;i++)
            alist.add(new ArrayList<>());

    }
    public static void main(String[] args) {
        topologicalSortDFS ts = new topologicalSortDFS(5);

        ts.addEdge(0,1);
        ts.addEdge(1,2);
        ts.addEdge(3,1);
        ts.addEdge(4,2);

        // ts.printList();
        ts.topoSort();
    }

    private void topoSort() {
        boolean[] visited = new boolean[number_of_vertex];
        Stack<Integer> stack = new Stack<>();

        // iterate over all nodes, and if not visited, then process dfs
        for (int i=0;i<number_of_vertex;i++){
            if (!visited[i]){
                topoSortUtil(i, visited, stack);
            }
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }

    }

    public void topoSortUtil(int src, boolean[] visited, Stack<Integer> stack){
        visited[src] = true;
        for (Integer vertex : alist.get(src)){
            if (!visited[src]){
                topoSortUtil(vertex, visited, stack);
            }
        }
        stack.push(src);

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
