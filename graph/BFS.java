package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
    private int number_of_vertex;;

    BFS(int V){
        number_of_vertex = V;
        for (int i=0;i<number_of_vertex;i++)
            alist.add(new ArrayList<>());

    }
    public static void main(String[] args) {
        BFS bfs = new BFS(4);

        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);

        // bfs.printList();
        bfs.getBFS(2);
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

    private void getBFS(int s) {
        boolean[] visited = new boolean[number_of_vertex];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()){
            s = queue.remove();
            System.out.print(s+" ");

            for (Integer vertex : alist.get(s)){
                if (!visited[vertex]){
                    queue.add(vertex);
                    visited[vertex] = true;
                }
            }

            /*Iterator it = alist.get(s).iterator();
            while(it.hasNext()){
                int vertex = (int)it.next();
                if (!visited[vertex]){
                    queue.add(vertex);
                    visited[vertex] = true;
                }
            }*/

        }
    }

}
