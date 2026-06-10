package graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(List.of(2,3,1)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(0,4)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(2)));

        System.out.println(dfs(adj));
    }

    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here

        int v = adj.size();
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[v];
        dfsRec(adj, res, visited, 0);
        return res;
    }

    private static void dfsRec(ArrayList<ArrayList<Integer>> adj,
                               ArrayList<Integer> res,boolean[] visited,
                               int src){

        visited[src] = true;
        res.add(src);

        for(int ele: adj.get(src)){
            if(!visited[ele]){
                dfsRec(adj, res, visited, ele);
            }
        }
    }
}
