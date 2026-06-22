package graph.circleDetection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectedGraphCycleBFS {

    public static void main(String[] args) {

        int V = 4;
        int[][] edges = {{0, 1}, {1, 2},{2,0},{2, 3}};
        System.out.println(isCyclic(V, edges));
    }


    public static boolean isCyclic(int V, int[][] edges) {
        // code here

        ArrayList<Integer>[] adj = new ArrayList[V];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj[i] = new ArrayList<>();
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            graph.get(edge[0]).add(edge[1]);
        }
        System.out.println(Arrays.toString(adj));
        System.out.println(graph);

        boolean[] visited = new boolean[V];

        boolean[] currPath = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i] && dfsISCyclic(adj, i, visited, currPath)){
                return true;
            }
        }
        return false;
    }

    private static boolean dfsISCyclic(ArrayList<Integer>[] adj, int u,
                                      boolean[] visited, boolean[] currPath){

        if(currPath[u]) return true;

        if(visited[u]) return false;

        visited[u] = true;
        currPath[u] = true;

        for(int neighbor: adj[u]){
            if(dfsISCyclic(adj,neighbor, visited, currPath)){
                return true;
            }
        }

        currPath[u] = false;
        return false;
    }
}
