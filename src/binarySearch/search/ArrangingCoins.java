package binarySearch.search;

public class ArrangingCoins {

    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }

    public static int arrangeCoins(int n) {
        long low = 0;
        long high = n;
        while(low <= high){
            long mid = low+ (high - low)/2;
            long coins = mid*(mid+1)/2;
            if(coins > n){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return (int)high;
    }
}
