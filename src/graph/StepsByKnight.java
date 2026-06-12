package graph;

import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {

    public static void main(String[] args) {

        int[] knightPos = {4, 5};
        int[] targetPos = {1, 1};
        System.out.println(minStepToReachTarget(knightPos,targetPos,6));
        //Output: 3
    }

    public static int minStepToReachTarget(int[] knightPos, int[] targetPos
            , int n) {
        // Knight's 8 possible moves

        if(knightPos[0] == targetPos[0] && knightPos[1] == targetPos[1]){
            return 0;
        }
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        boolean[][] visited = new boolean[n+1][n+1];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{knightPos[0],knightPos[1],0 });
        visited[knightPos[0]][knightPos[1]] = true;

        while (!q.isEmpty()){

            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int steps= curr[2];

            for (int i = 0; i < 8; i++) {
                int nx = x+ dx[i];
                int ny = y+ dy[i];

                if(nx >= 1 && nx <= n && ny >= 1 && ny <= n &&
                        !visited[nx][ny]){

                    if (nx == targetPos[0] && ny == targetPos[1]) {
                        return steps + 1;
                    }
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny,steps+1});
                }
            }

        }
        return -1;
    }

}
