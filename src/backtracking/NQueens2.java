package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens2 {

    public static void main(String[] args) {
        System.out.println(nQueen(4));
    }

    public static ArrayList<ArrayList<Integer>> nQueen(int n) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> position = new ArrayList<>();

        int[][] board = new int[n][n];
        helper(0, n, board, position, result);
        return result;
    }

    public static void helper(int colIdx, int n, int[][] board, ArrayList<Integer> position,
                              ArrayList<ArrayList<Integer>> result) {

        if (colIdx == n) {
            result.add(new ArrayList<>(position));
            return;
        }

        for (int rowIdx = 0; rowIdx < n; rowIdx++) {
            if (checkPosition(board, rowIdx, colIdx, n)) {
                board[rowIdx][colIdx] = 1;
                position.add(rowIdx + 1);
                helper(colIdx + 1, n, board, position, result);
                position.remove(position.size() - 1);
                board[rowIdx][colIdx] = 0;
            }
        }
    }

    private static boolean checkPosition(int[][] board, int row, int col, int n) {

        //left
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        //up digonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        //down diagonal
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
