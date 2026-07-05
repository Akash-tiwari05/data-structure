package graph.grids;

import java.util.*;

public class GeeksVillageAndWells {

    public static void main(String[] args) {

        int n = 5;
        int m = 5;

        char[][] c = {
                {'H','N','H','H','H'},
                {'N','N','H','H','W'},
                {'W','H','H','H','H'},
                {'H','H','H','H','H'},
                {'H','H','H','H','H'}
        };

        int[][] ans = chefAndWells(n,m,c);
        for (int[] row: ans){
            System.out.println(Arrays.toString(row));
        }
    }


    public static int[][] chefAndWells(int n, int m, char[][] c) {

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];

        // initialize dist = -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        // multi-source BFS from wells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (c[i][j] == 'W') {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {

            int size = q.size();

            for (int s = 0; s < size; s++) {

                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                int d = curr[2];
                for (int k = 0; k < 4; k++) {

                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (checkConditions(nx, ny, n, m) && !visited[nx][ny] && c[nx][ny] != 'N') {
                        visited[nx][ny] = true;
                        //houses--;
                        dist[nx][ny] = d+1;
                        q.offer(new int[]{nx, ny, d+1});
                    }
                }
            }
        }

        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (c[i][j] == 'H') {
                    ans[i][j] = dist[i][j] == -1 ? -1 : dist[i][j] * 2;
                }
            }
        }


        return ans;
    }
    private static boolean checkConditions(int nx, int ny, int n, int m){
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
}
