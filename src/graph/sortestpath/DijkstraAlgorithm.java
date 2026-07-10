package graph.sortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    public static void main(String[] args) {

        int src = 0;
        int V = 5;
        int[][] edges = {{0, 1, 4}, {0, 2, 8}, {1, 4, 6}, {2, 3, 2}, {3, 4, 10}};

        System.out.println(Arrays.toString(dijkstra(V, edges, src)));
    }

    public static int[] dijkstra(int V, int[][] edges, int src) {
        // code here

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            graph.get(u).add(new Pair(v, wt));

            // If graph is undirected
            graph.get(v).add(new Pair(u, wt));
        }

        // System.out.println(graph);

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.weight, b.weight));


        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()){

            Pair top = pq.poll();
            int d = top.weight;
            int u = top.node;

            if(d > dist[u]) continue;
            for (Pair nbr: graph.get(u)){
                int v = nbr.node;
                int wt = nbr.weight;

                if (dist[u] != Integer.MAX_VALUE &&
                        dist[u] + wt < dist[v]){
                    dist[v] = wt + dist[u];
                    pq.offer(new Pair(v, dist[v]));
                }
            }

        }

        return dist;
    }
}

class Pair{

    int node;
    int weight;

    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }

}