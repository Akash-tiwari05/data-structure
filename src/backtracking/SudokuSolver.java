package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class SudokuSolver {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
    }

    public static void solveSudoku(char[][] board) {

        boolean isValid  = helper(0,0, board);
        for(char[] row: board){
            System.out.println(Arrays.toString(row));
        }
    }

    private static boolean helper(int row, int col, char[][] board){
        if(row == 9){
            return true;
        }

        if(col == 9){
            return helper(row+1,0,board);
        }


        if(board[row][col] != '.'){
            return helper(row, col+1, board);
        }

        for (char i = '1'; i <= '9'; i++) {
            if(checkBoard(board,i,row,col)){
                board[row][col] = i ;
                if(helper(row,col+1,board)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    private static boolean checkBoard(char[][] board, char num, int row, int col){

        for (int i = 0; i < 9; i++) {

            if(board[i][col] == num){
                return false;
            }

            if(board[row][i] == num){
                return false;
            }
        }

        // 3x3 box
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;

    }
}
