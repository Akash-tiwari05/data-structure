package array;

public class LongestMountainInArray {

    public static void main(String[] args) {

        int[] arr = {2,1,4,7,3,2,5};
        System.out.println(longestMountain(arr));
    }

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
}
