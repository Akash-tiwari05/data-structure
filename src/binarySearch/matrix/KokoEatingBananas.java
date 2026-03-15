package binarySearch.matrix;

public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 5;
        System.out.println(minEatingSpeed(piles,h));
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int maxPiles = piles[0];
        for (int ele: piles) {
            maxPiles = Math.max(ele,maxPiles);
        }

        int low = 1;
        int high = maxPiles;
        int minPiles = 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(isVaid(piles,h,mid)){
                minPiles = mid;
                high = mid -1;
            }else{
                low = mid+1;
            }
        }

        return minPiles;
    }

    public static boolean isVaid(int[] piles,int h,int k){
        int hours = 0;
        for(int pile : piles){
            hours += (pile + k -1)/k;
        }
        return hours <= h;
    }
}
