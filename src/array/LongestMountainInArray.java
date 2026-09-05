package array;

public class LongestMountainInArray {

    public static void main(String[] args) {

        int[] arr = {2,2,2};
        System.out.println(longestMountain(arr));
        System.out.println(longestMountain2(arr));
    }

    // Optimal solution
    public static int longestMountain(int[] arr) {

        int i = 1;
        int n = arr.length;

        int maxi = 0;
        while(i < n){

            int peek = 1;

            while (i < n && arr[i] > arr[i - 1]){
                i++;
                peek++;

            }

            if(peek == 1) {
                i++;
                continue;
            };

            int down = 1;

            while (i < n && arr[i] < arr[i -1]){
                down++;
                i++;
            }

            if(down == 1){
                i++;
                continue;
            }

            maxi = Math.max(maxi, peek + down -1);
        }

        return maxi;
    }

    //better solution
    public static int longestMountain2(int[] arr) {

        int n = arr.length;
        int[] peek = new int[n];
        int[] down = new int[n];


        for (int i = 0; i < n; i++) {
            peek[i] =1;
            down[i] = 1;
        }


        //peek
        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]){
                peek[i] = 1 + peek[i -1];
            }
        }

        //down
        for (int i = n -2; i >= 0; i--) {
            if(arr[i] > arr[i+1]){
                down[i] = 1 + down[i +1];
            }
        }

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (peek[i] > 1 && down[i] > 1) {
                maxi = Math.max(maxi, peek[i] + down[i] - 1);
            }
        }

        return  maxi;
    }
}
