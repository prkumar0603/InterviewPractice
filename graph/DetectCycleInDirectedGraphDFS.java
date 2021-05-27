package graph;

import java.util.ArrayList;

public class DetectCycleInDirectedGraphDFS {
    private ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
    private int number_of_vertex;

    DetectCycleInDirectedGraphDFS(int V){
        number_of_vertex = V;
        for (int i=0;i<number_of_vertex;i++)
            alist.add(new ArrayList<>());
    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraphDFS obj = new DetectCycleInDirectedGraphDFS(4);

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
        boolean[] visited = new boolean[number_of_vertex];
        boolean[] order = new boolean[number_of_vertex];

        for (int i=0;i<number_of_vertex;i++)
            if (!visited[i]) {      // if vertex is not visited then run dfs
                if (isCyclicUtil(i, visited, order))    // run dfs and get result
                    return true;
            }
        return false;
    }

    private boolean isCyclicUtil(int src, boolean[] visited, boolean[] order) {
        visited[src] = true;
        order[src] = true;

        for (Integer vertex : alist.get(src)){
            if (!visited[vertex]) {
                if (isCyclicUtil(vertex, visited, order))
                    return true;
            }
            else if (order[vertex])
                return true;
        }

        order[src] = false;     // while backtracking, make that vertex false
        return false;
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
/* Approach - Predominantly DFS is used to find a cycle in graphs and not BFS.
      Depth first search is more memory efficient than breadth first search as you can
      backtrack sooner. It is also easier to implement if you use the call stack but this relies
      on the longest path not overflowing the stack.
*/