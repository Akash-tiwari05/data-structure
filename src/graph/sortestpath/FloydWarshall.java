package graph.sortestpath;

public class FloydWarshall {

    public static void main(String[] args) {
        int INF = (int)1e8;

        int[][] dist = {
                {0, 4, INF, 5, INF},
                {INF, 0, 1, INF, 6},
                {2, INF, 0, 3, INF },
                {INF, INF, 1, 0, 2},
                {1, INF, INF, 4, 0}
        };

        floydWarshall(dist);

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void floydWarshall(int[][] dist) {
        // Code here

        int V = dist.length;
        int INF = (int)1e8;

        // for each intermediate vertex
        // between source and destination
        for (int k = 0; k < V; k++) {

            // Pick all vertices as source one by one
            for (int i = 0; i < V; i++) {

                // Pick all vertices as destination
                // for the above picked source
                for (int j = 0; j < V; j++) {

                    // shortest path from i to j
                    if (dist[i][k] != INF && dist[k][j] != INF)
                        dist[i][j] = Math.min(dist[i][j],
                                dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
