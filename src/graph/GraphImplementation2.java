package graph;


public class GraphImplementation2 {

    static void printGraph(int[][] adjacencyMatrix, int n) {

        for (int i = 1; i < n; i++) {
            System.out.print("node: "+ i + " -> "
                    +"Neighbors: ");
            for (int j = 1; j < n; j++) {
                if(adjacencyMatrix[i][j] ==1){
                    System.out.print(j+" ");
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        int[][] edgeList = {{1, 2},{2,3},{3,4},{4,2},{1,3}};

        int maxNode = 0;
        for (int[] edge : edgeList) {
            maxNode = Math.max(maxNode,
                    Math.max(edge[0], edge[1]));
        }

        int n = maxNode + 1;

        int[][] adjacencyMatrix = new int[n][n];

        for (int[] edge : edgeList) {
            int a = edge[0];
            int b = edge[1];

            adjacencyMatrix[a][b] = 1;
            adjacencyMatrix[b][a] = 1; // undirected graph
        }


        printGraph(adjacencyMatrix, n);
    }
}
