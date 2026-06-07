package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        int[][] board = new int[n][n];
        helper(0, n, board,result);
        return result;
    }

    public static void helper(int colIdx, int n,int[][] board, List<List<String>> result){

        if(colIdx == n){
            result.add(buildBoard(board,n));
            return;
        }

        for (int rowIdx = 0; rowIdx < n; rowIdx++) {
            if(checkPosition(board,rowIdx , colIdx, n)){
                board[rowIdx][colIdx] = 1;
                helper(colIdx+1, n, board, result);
                //positions.remove(positions.size()-1);
                board[rowIdx][colIdx] = 0;
            }
        }
    }

    private static boolean checkPosition(int[][] board, int row, int col, int n){

        //left
        for (int i = 0; i < col; i++) {
            if(board[row][i] == 1){
                return false;
            }
        }

        //up digonal
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--,j--) {
            if(board[i][j] == 1){
                return false;
            }
        }

        //down diagonal
        for (int i = row+1, j = col-1; i < n && j >= 0; i++,j--) {
            if(board[i][j] == 1){
                return false;
            }
        }

        return true;
    }

    private static List<String> buildBoard(int[][] board, int n) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                sb.append(board[i][j] == 1 ? 'Q' : '.');
            }

            ans.add(sb.toString());
        }

        return ans;
    }


}
