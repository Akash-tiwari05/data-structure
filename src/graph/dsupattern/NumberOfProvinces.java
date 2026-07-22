package graph.dsupattern;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }

    private static int[] parent;
    private static int[] rank;

    private static int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] =i;
        }
        int provinces = n;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(isConnected[i][j] == 1 && find(i) != find(j)){
                    union(i,j);
                    provinces--;
                }
            }
        }

        return provinces;
    }

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


}
