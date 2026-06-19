package graph.circleDetection;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraphCycleDFS {

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

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        visited[0] = true;
        q.offer(edges[0][0]);
        while (!q.isEmpty()){

            int curr = q.poll();

            for(int neighbor: edges[curr]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }else{
                    return true;
                }

            }
        }
        return false;
    }
}
