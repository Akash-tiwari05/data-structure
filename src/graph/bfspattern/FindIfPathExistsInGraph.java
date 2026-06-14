package graph.bfspattern;

import java.util.*;

public class FindIfPathExistsInGraph {

    public static void main(String[] args) {

        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(validPath(6,edges,0,5));
        System.out.println(validPath2(6,edges,0,5));
    }

    //using bfs
    public static boolean validPath(int n, int[][] edges,
                                    int source, int destination) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] isVisited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        isVisited[source] = true;
        q.offer(source);


        while (!q.isEmpty()){
            int curr = q.poll();
            if(curr == destination){
                return true;
            }

            for(int neighbor: graph[curr]){
                if(!isVisited[neighbor]){
                    isVisited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        return isVisited[destination];
    }

    //dfs
    public static boolean validPath2(int n, int[][] edges,
                                    int source, int destination) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        dfsRec(source,graph,visited);

        return visited[destination];
    }

    private static void dfsRec(int source, List<Integer>[] graph, boolean[] visited){
        visited[source] = true;

        for(int neighbor: graph[source]){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                dfsRec(neighbor, graph, visited);
            }
        }
    }

}
