package graph.grids;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] islands =
                {{'1','1', '1', '1', '0'},
                 {'1','1', '0', '1', '0'},
                 {'1','1', '0', '0', '0'},
                 {'0','0', '0', '0', '0'}};
        System.out.println(numIslands2(islands));
        System.out.println(numIslands(islands));
    }

    public static int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[] dx = {1,0,-1, 0};
        int[] dy = {0, 1, 0, -1};


        boolean[][] visited = new boolean[m][n];
        int countIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(!visited[i][j] && grid[i][j] == '1'){
                    countIsland++;
                    bfs(grid, m, n, i , j, dx, dy, visited);
                }
            }
        }

        return countIsland;

    }

    private static void bfs(char[][] grid, int m, int n, int sr,
                            int sc,int[] dx, int[] dy, boolean[][] visited){

        Queue<int[]> q = new LinkedList<>();
        visited[sr][sc] = true;
        q.offer(new int[]{sr, sc});

        while (!q.isEmpty()){
            int i = q.peek()[0];
            int j = q.peek()[1];
            q.poll();

            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (checkConditions(x, y, m, n)
                        && !visited[x][y]
                        && grid[x][y] == '1') {

                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        }
    }

    private static boolean checkConditions(int x, int y, int m, int n){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static int numIslands2(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[] dx = {1,0,-1, 0};
        int[] dy = {0, 1, 0, -1};

        boolean[][] visited = new boolean[m][n];
        int countIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(!visited[i][j] && grid[i][j] == '1'){
                    countIsland++;
                    islands(grid, i, j,visited, m , n, dx, dy);
                }
            }
        }

        return countIsland;

    }

    private static void islands(char[][] grid, int sr, int sc
                             , boolean[][] visited , int m, int n, int[] dx, int[] dy){

        if(sr < 0 || sr >= m || sc < 0 || sc >= n || grid[sr][sc] == '0') return;

        if (visited[sr][sc])
            return;

        visited[sr][sc]= true;
        for (int i = 0; i < 4; i++){
            islands(grid, sr+ dx[i] , sc + dy[i], visited,m, n, dx, dy);
        }
    }

}
