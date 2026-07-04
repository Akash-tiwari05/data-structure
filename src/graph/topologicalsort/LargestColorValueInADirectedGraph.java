package graph.topologicalsort;

import java.util.*;

public class LargestColorValueInADirectedGraph {

    public static void main(String[] args) {

        int[][] edges = {{0,1},{0,2},{2,3},{3,4}};
        String colors = "abaca";
        System.out.println(largestPathValue(colors,edges));
    }

    public static int largestPathValue(String colors, int[][] edges) {

        int V = colors.length();
        List<Integer>[] adj = new List[V];
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge: edges){
            indegree[edge[1]]++;
            adj[edge[0]].add(edge[1]);
        }

        //System.out.println(Arrays.toString(adj));
        //boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        int[][] colorCount = new int[V][26];
        for (int i = 0; i < V; i++) {
            if(indegree[i] == 0){
                q.offer(i);
                colorCount[i][colors.charAt(i) - 'a'] = 1;
            }
        }



        int ans = 0;
        int proceed= 0;
        while(!q.isEmpty()){

            int curr = q.poll();
            proceed += 1;
            // Update answer
            for (int c = 0; c < 26; c++) {
                ans = Math.max(ans, colorCount[curr][c]);
            }

            for (int nbr : adj[curr]) {

                // Update DP for neighbour
                for (int c = 0; c < 26; c++) {

                    int value = colorCount[curr][c];

                    if (c == colors.charAt(nbr) - 'a') {
                        value++;
                    }

                    colorCount[nbr][c] = Math.max(colorCount[nbr][c], value);
                }

                indegree[nbr]--;

                if (indegree[nbr] == 0) {
                    q.offer(nbr);
                }
            }
        }

        return (proceed == V)? ans : -1;
    }
}
