package greedy;

public class CandyDistribution {

    public static void main(String[] args) {

        int[] arr = {1,5,2,1,2};
        System.out.println(candy(arr));
    }


    public static int candy(int[] arr) {
        int n = arr.length;
        int[] candies = new int[n];
        candies[0] = 1;

        //for left distribution
        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]){
                candies[i] = candies[i-1]+1;
            }
            else{
                candies[i] = 1;
            }
        }
        for (int i = n-2; i >= 0; i--) {
            if(arr[i] > arr[i+1]){
                candies[i] = Math.max(candies[i],candies[i+1]+1);
            }

        }

        int minimumDis = 0;
        for(int candie : candies){
            minimumDis += candie;
        }

        return minimumDis;
    }

    //optimize space
    public int candy2(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;

        int candies = 1;
        int up = 0, down = 0, peak = 0;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                up++;
                peak = up;
                down = 0;
                candies += 1 + up;
            }
            else if (ratings[i] < ratings[i - 1]) {
                up = 0;
                down++;
                candies += down;
                if (down > peak) {
                    candies++;
                }
            }
            else {
                up = 0;
                down = 0;
                peak = 0;
                candies += 1;
            }
        }
        return candies;
    }

}
