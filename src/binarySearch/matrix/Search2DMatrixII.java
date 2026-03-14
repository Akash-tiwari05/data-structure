package binarySearch.matrix;

public class Search2DMatrixII {
    public static void main(String[] args) {

        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int key = 3;

        System.out.println(searchMatrix(arr,key));
    }

    //naive solution
    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n-1;
        while(j >= 0 && i < m){
            if(matrix[i][j] == target) {
                //System.out.println(i +","+j);
                return true;
            }
            else if(matrix[i][j] > target){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
}
