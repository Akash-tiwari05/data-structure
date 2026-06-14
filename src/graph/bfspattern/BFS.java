package graph.bfspattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(List.of(2,3,1)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(0,4)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(2)));

        System.out.println(bfs(adj));
    }

    // BFS for single connected component
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here

        int v = adj.size();
        boolean[] visited = new boolean[v];
        ArrayList<Integer> res = new ArrayList<>();

        int src = 0;
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.add(src);

        while (!q.isEmpty()){

            int curr = q.poll();
            res.add(curr);

            for(int ele: adj.get(curr)){
                if(!visited[ele]){
                    visited[ele] = true;
                    q.add(ele);
                }
            }

        }
        return res;

    }
}
