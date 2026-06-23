package graph.circleDetection;

public class LongestCycleInAGraph {

    public static void main(String[] args) {

        int[]  edges = {3,3,4,2,3};
        System.out.println(longestCycle(edges));
    }

    private static int longestCycleLen;
    public static int longestCycle(int[] edges) {

        int n = edges.length;

        longestCycleLen = -1;
        boolean[] visited = new boolean[n];
        int[] currPath = new int[n];
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                dfs(0, edges, i, visited,currPath);
            }
        }
        return longestCycleLen;
    }

    private static void dfs(int cycleLen, int[] edge, int node,
                               boolean[] visited, int[] currPath){
        cycleLen++;
        visited[node] = true;
        currPath[node] = cycleLen;

        int neighbor = edge[node];

        if (neighbor != -1) {
            if (!visited[neighbor]) {
                dfs(cycleLen, edge, neighbor, visited, currPath);
            } else if (currPath[neighbor] != 0) {
                int currCycleLen = currPath[node] - currPath[neighbor] + 1;
                longestCycleLen = Math.max(currCycleLen, longestCycleLen);
            }
        }

        currPath[node] = 0;

    }
}
