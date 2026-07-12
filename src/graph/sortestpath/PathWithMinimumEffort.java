package graph.sortestpath;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    public static void main(String[] args) {

        int[][] heights = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};

        System.out.println(minimumEffortPath(heights));
    }

    public static int minimumEffortPath(int[][] heights) {

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        int m = heights.length;
        int n = heights[0].length;

        int[][] effort = new int[m][n];

        for(int[] row: effort){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) ->
                Integer.compare(a.absDiff, b.absDiff));

        pq.offer(new Node(0,0,0));

        while (!pq.isEmpty()){

            Node top = pq.poll();

            int xCrd = top.x;
            int yCrd = top.y;
            int parent = top.absDiff;

            if (xCrd == m - 1 && yCrd == n - 1)
                return parent;

            for (int i = 0; i < 4; i++) {
                int newX = xCrd + dx[i];
                int newY = yCrd + dy[i];


                if (checkConditions(newX, newY, m, n)){
                    int newEffort = Math.max(parent,
                            Math.abs(heights[newX][newY] - heights[xCrd][yCrd]));

                    if (newEffort < effort[newX][newY]) {
                        effort[newX][newY] = newEffort;
                        pq.offer(new Node(newX, newY, newEffort));
                    }
                }

            }

        }
        return 0;

    }

    private static boolean checkConditions(int x, int y, int m, int n){

        return x >= 0 && x < m && y >= 0 && y < n;
    }


}

class Node {
    int x;
    int y;

    int absDiff;

    Node(int x, int y, int absDiff){
        this.x = x;
        this.y = y;
        this.absDiff = absDiff;
    }

}