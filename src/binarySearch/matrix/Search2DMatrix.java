package binarySearch.matrix;

public class Search2DMatrix {

    public static void main(String[] args) {

        int[][] arr = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24}};
        int key = 5;

        System.out.println(searchMatrix(arr,key));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m*n - 1;
        while (low <= high) {
            int mid = low+ (high - low)/2;

            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                //System.out.println(i +","+j);
                return true;
            } else if (matrix[row][col] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return false;
    }
}
