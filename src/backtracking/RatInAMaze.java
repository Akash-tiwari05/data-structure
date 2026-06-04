package backtracking;

import java.util.ArrayList;

public class RatInAMaze {

    public static void main(String[] args) {

        int[][] mage = {{1, 0, 0, 0}, {1, 1, 0, 1},
                {1, 1, 0, 0}, {0, 1, 1, 1}};

        System.out.println(ratInMaze(mage));
    }

    public static ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
        ArrayList<String> paths = new ArrayList<>();

        if(maze[0][0] == 0 || maze[n-1][n-1] == 0){
            return paths;
        }

        boolean[][] visited = new boolean[n][n];
        findPath(0,0,maze, visited,n, "", paths);
        return paths;
    }

    private static void findPath(int x, int y, int[][] maze,
                                 boolean[][] visited,int n, String currentPaths,
                                 ArrayList<String> paths){

        if(x == n-1 && y == n-1){
            paths.add(currentPaths);
            return;
        }

        visited[x][y] = true;

        //down
        if(x+1 < n && maze[x+1][y] == 1 && !visited[x+1][y]){
            findPath(x+1,y, maze,visited,n,currentPaths+"D",paths);
        }

        //left
        if(y-1 >= 0 && maze[x][y-1] == 1 && !visited[x][y-1]){
            findPath(x,y-1, maze,visited,n,currentPaths+"L",paths);
        }

        //right
        if(y+1 < n && maze[x][y+1] == 1 && !visited[x][y+1]){
            findPath(x,y+1, maze,visited,n,currentPaths+"R",paths);
        }



        //up
        if(x-1 >= 0 && maze[x-1][y] == 1 && !visited[x-1][y]){
            findPath(x-1,y, maze,visited,n,currentPaths+"U",paths);
        }

        visited[x][y] = false;
    }
}
