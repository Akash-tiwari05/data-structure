package graph.bfspattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderRoutes {

    public static void main(String[] args) {

        int[][] connections = {{0, 1},{1, 3},{2, 3},{4, 0},{4,5}};
        System.out.println(minReorder(6, connections));
    }

    public static int minReorder(int n, int[][] connections) {

        List<Integer>[] forwardConnection = new ArrayList[n];
        List<Integer>[] backwardConnection = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            forwardConnection[i] = new ArrayList<>();
            backwardConnection[i] = new ArrayList<>();
        }

        for (int i = 0; i < connections.length; i++) {
            int city1 = connections[i][0];
            int city2 = connections[i][1];
            forwardConnection[city1].add(city2);
            backwardConnection[city2].add(city1);
        }

        /*System.out.println(Arrays.toString(forwardConnection));
        System.out.println(Arrays.toString(backwardConnection));*/

        boolean[] visited = new boolean[n];

        return dfsRoutes(0, forwardConnection,backwardConnection,
                visited);
    }
    //dfs
    public static int dfsRoutes(int source,
                                 List<Integer>[] forwardConnection,
                                 List<Integer>[] backwardConnection,
                                 boolean[] visited){

        visited[source] = true;

        int changes = 0;

        //forward
        for (int neighbor: forwardConnection[source]) {
            if(!visited[neighbor]){
                changes += 1;
                changes +=dfsRoutes(neighbor,forwardConnection,backwardConnection,visited);
            }
        }

        //backward
        for (int neighbor: backwardConnection[source]) {
            if (!visited[neighbor]) {
                changes += dfsRoutes(neighbor, forwardConnection, backwardConnection,
                        visited);
            }
        }
        return changes;
    }
}
