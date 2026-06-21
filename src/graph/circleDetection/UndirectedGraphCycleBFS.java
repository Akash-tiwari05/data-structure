package graph.circleDetection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraphCycleBFS {

    public static void main(String[] args) {
        int V = 4, E = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(isCycle(V, edges));

    }

    public static boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(adj, i, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean bfs(ArrayList<Integer>[] adj, int start,
                              boolean[] visited){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, -1});
        visited[start] = true;
        while (!q.isEmpty()){
            int node = q.peek()[0];
            int parent = q.peek()[1];

            q.poll();
            for(int neighbor: adj[node]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.offer(new int[] {neighbor, node});
                }else if(parent != neighbor){
                    return true;
                }

            }
        }
        return false;
    }
}
