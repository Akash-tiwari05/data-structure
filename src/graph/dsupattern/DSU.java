package graph.dsupattern;

import java.util.Arrays;

public class DSU {

    private static int[] parent;
    private static int[] rank;

    public static int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    public static void union(int nodeA, int nodeB) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);

        if (rootA != rootB) {
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
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
