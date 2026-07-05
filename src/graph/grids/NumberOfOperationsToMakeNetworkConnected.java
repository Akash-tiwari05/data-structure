package graph.grids;

import java.util.*;

public class NumberOfOperationsToMakeNetworkConnected {

    public static void main(String[] args) {

        int n = 6;
        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};

        System.out.println(makeConnected(n, connections));
        System.out.println(makeConnected2(n, connections));
    }

    // using bfs
    public static int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1)
            return -1;

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : connections) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        System.out.println(Arrays.toString(adj));

        boolean[] visited = new boolean[n];
        int cables = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                cables++;
                bfs(adj, i, visited);
            }
        }
        return cables - 1;
    }

    private static void bfs(List<Integer>[] adj, int node, boolean[] visited){

        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.offer(node);

        while (!q.isEmpty()){
            int curr = q.poll();

            for (int nbr : adj[curr]){
                if(!visited[nbr]){
                    visited[nbr] = true;
                    q.offer(nbr);
                }
            }
        }
    }
    //using dfs
    public static int makeConnected2(int n, int[][] connections) {

        if (connections.length < n - 1)
            return -1;

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : connections) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int cables = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cables++;
                dfs(adj, i, visited);
            }
        }
        return cables - 1;
    }
    private static void dfs(List<Integer>[] adj, int node, boolean[] visited){


        visited[node] = true;

        for (int nbr : adj[node]){
            if(!visited[nbr]){
                dfs(adj, nbr, visited);
            }
        }
    }
}
