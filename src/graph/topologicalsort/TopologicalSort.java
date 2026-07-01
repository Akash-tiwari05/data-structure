package graph.topologicalsort;

import java.util.*;

//khans algo
public class TopologicalSort {

    public static void main(String[] args) {

        int[][] edges = {{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5, 2}};
        System.out.println(topoSort(6, edges));
        System.out.println(topoSort2(6, edges));
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here

        List<Integer>[] adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge: edges){
            adj[edge[0]].add(edge[1]);
        }

        //System.out.println(Arrays.toString(adj));

        int[] indegree = new int[V];
        ArrayList<Integer>topoOrder = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        //filling indegree
        for(int[] edge : edges){
            int destinations = edge[1];
            indegree[destinations]++;
        }

        //adding queue
        for (int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }


        while (!q.isEmpty()){
            int curr = q.poll();
            topoOrder.add(curr);

            for(int nbr: adj[curr]){

                indegree[nbr]--;

                if(indegree[nbr] == 0){
                    q.offer(nbr);
                }
            }
        }
        return topoOrder;
    }

    //using dfs
    public static ArrayList<Integer> topoSort2(int V, int[][] edges) {
        // code here

        List<Integer>[] adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge: edges){
            adj[edge[0]].add(edge[1]);
        }

        //System.out.println(Arrays.toString(adj));
        boolean[] visited = new boolean[V];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < V; i++) {

            if(!visited[i]) {
                dfs(adj, i, visited, dq);
            }
        }

        ArrayList<Integer> topoSort = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            topoSort.add(dq.pollFirst());
        }
        return topoSort;
    }

    private static void dfs(List<Integer>[] adj, int node,
                            boolean[] visited, Deque<Integer> dq){

        visited[node] = true;
        for(int neighbor : adj[node]){
            if(!visited[neighbor]){
                dfs(adj, neighbor, visited, dq);
            }
        }

        dq.offerFirst(node);
    }
}
 
