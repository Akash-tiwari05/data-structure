package graph.grids;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {

        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[] dx = {1,0,-1, 0};
        int[] dy = {0, 1, 0, -1};

        List<int[]> rottenSrc = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(grid[i][j] == 2){
                    rottenSrc.add(new int[]{i, j});
                }
            }
        }

        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    fresh++;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rottenSrc.size(); i++) {
            q.offer(rottenSrc.get(i));
        }

        int minutes = 0;
        while (!q.isEmpty() && fresh > 0){

            int size = q.size();

            for (int s = 0; s < size; s++) {

                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                for (int k = 0; k < 4; k++) {

                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (checkConditions(x, y, m, n) && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        q.offer(new int[]{x, y});

                    }
                }
            }

            minutes++;
        }
        return fresh == 0? minutes : -1;

    }
    private static boolean checkConditions(int x, int y, int m, int n){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
