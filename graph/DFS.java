package graph;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
    int number_of_vertex;

    DFS(int V){
        number_of_vertex = V;
        for (int i=0;i<number_of_vertex;i++)
            alist.add(new ArrayList<>());
    }

    public static void main(String[] args) {
        DFS dfs = new DFS(4);

        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        dfs.printlist();
        dfs.getDFS(2);
    }

    private void getDFS(int s) {
        boolean[] visited = new boolean[number_of_vertex];

        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        visited[s] = true;

        while (!stack.isEmpty()){
            s = stack.pop();
            System.out.print(s+" ");

            for (int vertex : alist.get(s)){
                if (!visited[vertex]){
                    stack.push(vertex);
                    visited[vertex] = true;
                }
            }

        }
    }

    private void printlist() {
        for (int i=0;i<alist.size();i++){
            System.out.print("vertex "+ i);
            for (int j=0;j<alist.get(i).size();j++){
                System.out.print(" -> " + alist.get(i).get(j));
            }
            System.out.println();
        }
    }

    private void addEdge(int u, int v) {
        alist.get(u).add(v);
    }



}
