package graph.sortestpath;

import java.util.Arrays;

public class BellmanFord {

    public static void main(String[] args) {

        int[][] edges = {{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}};
        int V = 5;
        int src = 0;
        System.out.println(Arrays.toString(bellmanFord(V, edges, src)));
    }

    public static int[] bellmanFord(int V, int[][] edges, int src) {
        // code here

        int INF = (int) 1e8;
        int[] dist = new int[V];

        Arrays.fill(dist,INF);
        dist[src] = 0;

        //Relaxation edge
        for (int i = 1; i < V; i++) {

            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(dist[u] != INF && dist[u]+ wt < dist[v]){
                    dist[v] = dist[u]+ wt;
                }
            }
        }

        //check negative wt graph
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if(dist[u] != INF && dist[u]+ wt < dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
}
