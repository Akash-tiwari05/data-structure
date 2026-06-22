package graph.circleDetection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindEventualSafeStates {

    public static void main(String[] args) {

        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(graph.length);
        System.out.println(eventualSafeNodes(graph));
        System.out.println(eventualSafeNodes2(graph));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {

        int V = graph.length;

        ArrayList<Integer> res = new ArrayList<>();

        boolean[] visited = new boolean[V];
        boolean[] currPath = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                dfsUnSafePath(graph, i, visited, currPath);
            }
        }
        System.out.println(Arrays.toString(currPath));

        for (int i = 0; i < V; i++) {
            if(!currPath[i]){
                res.add(i);
            }
        }
        return res;
    }

    private static boolean dfsUnSafePath(int[][] graph, int node,
                                       boolean[] visited, boolean[] state){

        if(state[node]) return true;

        if(visited[node]) return false;

        visited[node] = true;
        state[node] = true;

        for(int neighbor: graph[node]){

            if(!visited[neighbor]){
                boolean ans = dfsUnSafePath(graph,neighbor, visited, state);
                if(ans){
                    return true;
                }
            } else if (state[neighbor]){
                return true;
            }
        }

        state[node] = false;
        return false;
    }

    public static List<Integer> eventualSafeNodes2(int[][] graph) {

        int V = graph.length;

        ArrayList<Integer> res = new ArrayList<>();

        int[] state = new int[V];

        for (int i = 0; i < V; i++) {
            if(dfs(graph, i, state)){
                res.add(i);
            }
        }
        return res;
    }

    private static boolean dfs(int[][] graph, int node, int[] state) {

        if(state[node] != 0) {
            return state[node] == 2;
        }

        state[node] = 1; // visiting

        for(int nei : graph[node]) {
            if(!dfs(graph, nei, state)) {
                return false;
            }
        }

        state[node] = 2; // safe
        return true;
    }
}
