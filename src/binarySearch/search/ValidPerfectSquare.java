package binarySearch.search;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(26));
    }

    public static boolean isPerfectSquare(int num) {
        long low = 0;
        long high = num;
        while (low <= high){
            long mid = low + (high-low)/2;
            long square = mid*mid;
            if(square == num){
                return true;
            }
            if(square < num){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return false;
    }
}
