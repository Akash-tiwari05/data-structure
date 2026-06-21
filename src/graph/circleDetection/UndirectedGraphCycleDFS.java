package graph.circleDetection;

import java.util.ArrayList;

public class UndirectedGraphCycleDFS {

    public static void main(String[] args) {
        int V = 4, E = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(isCycle(V, edges));

    }

    public static boolean isCycle(int V, int[][] edges) {

        ArrayList<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[V];

        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                if (dfs(u, adj, visited, -1))
                    return true;
            }
        }

        return false;
    }

    private static boolean dfs(int v, ArrayList<Integer>[] adj, boolean[] visited, int parent){

        visited[v] = true;

        for (int neighbor: adj[v]) {

            if(!visited[neighbor]){

                if(dfs(neighbor, adj, visited,v)){
                    return true;
                }
            }
            else if(neighbor != parent){
                return true;
            }
        }
        return false;

    }

}
