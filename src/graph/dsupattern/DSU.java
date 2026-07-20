package graph.dsupattern;

import java.util.Arrays;

public class DSU {

    static int[] parent;
    static int[] rank;


    public static int find(int x){

        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        int lead_a = find(a);
        int lead_b = find(b);

        if (lead_a != lead_b) {
            // Union by Rank optimization
            if (rank[lead_a] < rank[lead_b]) {
                parent[lead_a] = lead_b;
            } else if (rank[lead_a] > rank[lead_b]) {
                parent[lead_b] = lead_a;
            } else {
                parent[lead_b] = lead_a;
                rank[lead_a]++;
            }
        }
    }


    public static void main(String[] args) {

        int[][] graph = {{1,2},{1,3},{4,5}};

        int maxNode = 0;
        for (int[] edge : graph) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }

        int size = maxNode+1;
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < graph.length; i++) {
            union(graph[i][0], graph[i][1]);
        }
        System.out.println(Arrays.toString(parent));
    }
}
